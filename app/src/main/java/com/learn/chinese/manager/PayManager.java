package com.learn.chinese.manager;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.learn.chinese.base.BaseApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jin
 * @Description: 支付管理类
 * @CreateDate: 2023/7/18  11:17
 */
public class PayManager {
    private static final String TAG = "PayManager";
    private BillingClient mBillingClient;

    public static PayManager getInstance() {
        return PayHelper.payManager;
    }

    private static class PayHelper {
        private static final PayManager payManager = new PayManager();
    }

    private PayManager() {
        mBillingClient = BillingClient.newBuilder(BaseApplication.getContext()).setListener(mPurchasesUpdatedListener).enablePendingPurchases().build();
    }

    private PurchasesUpdatedListener mPurchasesUpdatedListener = (billingResult, list) -> {
        String debugMessage = billingResult.getDebugMessage();
        if (list != null && list.size() > 0) {
            if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                for (Purchase purchase : list) {
                    if (purchase == null || purchase.getPurchaseState() != Purchase.PurchaseState.PURCHASED)
                        continue;
                    Log.i(TAG, "PurchasesUpdatedListener pay success");
                    // 通知服务器支付成功，服务端验证后，消费商品
                    // TODO 客户端同步回调支付成功
                }
            }
        } else {
            Log.e(TAG, "PurchasesUpdatedListener pay failed:" + billingResult.getResponseCode());
            switch (billingResult.getResponseCode()) {
                case BillingClient.BillingResponseCode.SERVICE_TIMEOUT: //服务连接超时
                    break;

                case BillingClient.BillingResponseCode.FEATURE_NOT_SUPPORTED:
                    break;

                case BillingClient.BillingResponseCode.SERVICE_DISCONNECTED: //服务未连接
                    break;

                case BillingClient.BillingResponseCode.USER_CANCELED: //取消
                    break;

                case BillingClient.BillingResponseCode.SERVICE_UNAVAILABLE: //服务不可用
                    break;

                case BillingClient.BillingResponseCode.BILLING_UNAVAILABLE: //购买不可用
                    break;

                case BillingClient.BillingResponseCode.ITEM_UNAVAILABLE: //商品不存在
                    break;

                case BillingClient.BillingResponseCode.DEVELOPER_ERROR: //提供给 API 的无效参数
                    break;

                case BillingClient.BillingResponseCode.ERROR: //错误

                    break;

                case BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED: //未消耗掉

                    break;

                case BillingClient.BillingResponseCode.ITEM_NOT_OWNED: //不可购买
                    break;

            }
        }
    };

    public void pay(final String cpOrder, final String productId, Activity activity) {
        Log.i(TAG, "pay cpOrder:" + cpOrder + ",productId:" + productId);
        if (mBillingClient == null || !mBillingClient.isReady()) {
            // TODO 客户端同步回调支付失败，原因是为链接到google或者google的支付服务不能使用
            mBillingClient.startConnection(new BillingClientStateListener() {  //重新连接
                @Override
                public void onBillingServiceDisconnected() {
                    // 尝试重新启动连接的下一个请求
                    // 谷歌通过调用startConnection()方法进行播放。
                    Log.e(TAG, "onBillingServiceDisconnected");
                }

                @Override
                public void onBillingSetupFinished(@NonNull BillingResult billingResult) {
                    Log.i(TAG, "onBillingSetupFinished billingResult:" + billingResult.getResponseCode());
                    if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                        // BillingClient已经准备好。 你可以在这里查询购买情况。
                        querySkuDetailsAsync(cpOrder, productId, activity);
                    }
                }
            });
            return;
        }
        // 查询商品详情
        querySkuDetailsAsync(cpOrder, productId, activity);
    }

    private void querySkuDetailsAsync(final String cpOrder, final String productId, Activity activity) {
        Log.i(TAG, "querySkuDetailsAsync cpOrder:" + cpOrder + ",productId:" + productId);
        List<String> skuList = new ArrayList<>();
        skuList.add(productId);
        SkuDetailsParams.Builder params = SkuDetailsParams.newBuilder();
        params.setSkusList(skuList).setType(BillingClient.SkuType.INAPP);
        mBillingClient.querySkuDetailsAsync(params.build(), (billingResult, skuDetailsList) -> {
            Log.i(TAG, "querySkuDetailsAsync billingResult:" + billingResult.getResponseCode());
            if (skuDetailsList != null && billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                Log.i(TAG, "querySkuDetailsAsync skuDetailsList.size:" + skuDetailsList.size());
                for (SkuDetails skuDetails : skuDetailsList) {
                    if (productId.equals(skuDetails.getSku())) {
                        // 发起支付
                        launchBillingFlow(cpOrder, skuDetails, activity);
                    }
                }
            }
        });
    }

    /**
     * 拉取google支付页面
     *
     * @param cpOrder    你自己的订单号或者用户id，用于关联到对应的用户，发放道具时使用
     * @param skuDetails
     */
    private void launchBillingFlow(String cpOrder, SkuDetails skuDetails, Activity activity) {
        Log.i(TAG, "launchBillingFlow cpOrder:" + cpOrder);
        mBillingClient.launchBillingFlow(activity,
                BillingFlowParams.newBuilder().setSkuDetails(skuDetails)
                        .setObfuscatedAccountId(cpOrder)//这里本来的意思存放用户信息，类似于国内的透传参数，我这里传的我们的订单号。老版本使用DeveloperPayload字段，最新版本中这个字段已不可用了
                        .build()
        );
    }

    public void consumePurchase(final Purchase purchase) {
        if (mBillingClient == null || purchase == null || purchase.getPurchaseState() != Purchase.PurchaseState.PURCHASED)
            return;
        Log.i(TAG, "consumePurchase 消耗商品：商品id：" + purchase.getSkus() + "商品OrderId：" + purchase.getOrderId() + "token:" + purchase.getPurchaseToken());

        ConsumeParams consumeParams = ConsumeParams.newBuilder()
                .setPurchaseToken(purchase.getPurchaseToken())
                .build();
        ConsumeResponseListener listener = (billingResult, purchaseToken) -> {
            if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.ERROR) {
                //消费失败将商品重新放入消费队列

                return;
            }
            Log.i(TAG, "消费成功: ");
        };
        mBillingClient.consumeAsync(consumeParams, listener);
    }

    /**
     * 补单操作 查询已支付的商品，并通知服务器后消费（google的支付里面，没有消费的商品，不能再次购买）
     */
    private void queryPurchases() {
        PurchasesResponseListener mPurchasesResponseListener = new PurchasesResponseListener() {

            @Override
            public void onQueryPurchasesResponse(@NonNull BillingResult billingResult, @NonNull List<Purchase> purchasesResult) {
                if (billingResult.getResponseCode() != BillingClient.BillingResponseCode.OK || purchasesResult == null)
                    return;
                for (Purchase purchase : purchasesResult) {

                    if (purchase != null) {
                        consumePurchase(purchase);
                    }
                    if (purchase == null || purchase.getPurchaseState() != Purchase.PurchaseState.PURCHASED)
                        continue;

                    //这里处理已经支付过的订单，通知服务器去验证  并消耗商品
                }
            }
        };
        mBillingClient.queryPurchasesAsync(BillingClient.SkuType.INAPP, mPurchasesResponseListener);
    }

}

package com.learn.chinese.util;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Iterator;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/27  18:29
 */
public class SkProvider extends ContentProvider {

    public static final Uri AUTHORITY_URI = Uri.parse("content://com.sk.provider/learn_cn");
    public static final Uri CONTENT_URI = AUTHORITY_URI;

    public static final String PARAM_KEY = "key";
    public static final String PARAM_VALUE = "value";

    private static final String PREFERENCE_NAME = "LEARN_CN";

    private SharedPreferences mStore;

    @Override
    public boolean onCreate() {
        mStore = getContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Log.i("SkProvider", "query projection:" + projection.toString());
        // 跨进程访问
        int size = projection == null ? 0 : projection.length;
        if (size > 0) {
            String[] values = new String[size];
            for (int i = 0; i < size; i++) {
                // 读取SkProvider进程的SP的值
                values[i] = getValue(projection[i], null);
            }
            // SP值封装到Cursor，回传给访问进程
            return createCursor(projection, values);
        }
        String key = uri.getQueryParameter(PARAM_KEY);
        String value = null;
        if (!TextUtils.isEmpty(key)) {
            // 读取SkProvider进程的SP的值
            value = getValue(key, null);
        }
        // SP值封装到Cursor，回传给访问进程
        return createSingleCursor(key, value);
    }

    protected Cursor createSingleCursor(String key, String value) {
        MatrixCursor cursor = new MatrixCursor(new String[]{key}, 1);
        if (!TextUtils.isEmpty(value)) {
            cursor.addRow(new Object[]{value});
        }
        return cursor;
    }

    protected String getValue(String key, String defValue) {
        return mStore.getString(key, defValue);
    }

    protected Cursor createCursor(String[] keys, String[] values) {
        MatrixCursor cursor = new MatrixCursor(keys, 1);
        cursor.addRow(values);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        if (values != null && values.size() > 0) {
            save(values);
        } else {
            String key = uri.getQueryParameter(PARAM_KEY);
            String value = uri.getQueryParameter(PARAM_VALUE);
            if (!TextUtils.isEmpty(key)) {
                save(key, value);
            }
        }
        return null;
    }

    protected void save(ContentValues values) {
        String key;
        String value;
        Iterator<String> iterator = values.keySet().iterator();
        SharedPreferences.Editor editor = mStore.edit();
        while (iterator.hasNext()) {
            key = iterator.next();
            value = values.getAsString(key);
            if (!TextUtils.isEmpty(key)) {
                if (value != null) {
                    editor.putString(key, value);
                } else {
                    // 需要删除数据的时候value传null
                    editor.remove(key);
                }
            }
        }
        editor.commit();
    }

    protected void save(String key, String value) {
        SharedPreferences.Editor editor = mStore.edit();
        if (value != null) {
            editor.putString(key, value);
        } else {
            editor.remove(key);
        }
        editor.commit();
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        String key = selection != null ? selection : uri.getQueryParameter(PARAM_KEY);
        if (!TextUtils.isEmpty(key)) {
            remove(key);
            return 1;
        }
        return 0;
    }

    protected void remove(String key) {
        SharedPreferences.Editor editor = mStore.edit();
        editor.remove(key);
        editor.commit();
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    /**
     * 使用query方法查询SkProvider进程的SP数据
     *
     * @param context
     * @param keys
     * @return
     */
    private static Cursor query(Context context, String... keys) {
        return context.getContentResolver().query(CONTENT_URI, keys, null, null, null);
    }

    /**
     * 跨进程访问SP
     *
     * @param context
     * @param key
     * @return
     */
    public static String getString(Context context, String key) {
        return getString(context, key, null);
    }

    public static String getString(Context context, String key, String defValue) {
        // 使用query方法查询SkProvider进程的SP数据
        Cursor cursor = query(context, key);
        String ret = defValue;
        if (cursor.moveToNext()) {
            ret = cursor.getString(0);
            if (TextUtils.isEmpty(ret)) {
                ret = defValue;
            }
        }
        cursor.close();
        return ret;
    }

    public static int getInt(Context context, String key) {
        return getInt(context, key, 0);
    }

    public static int getInt(Context context, String key, int defValue) {
        // 使用query方法查询SkProvider进程的SP数据
        Cursor cursor = query(context, key);
        int ret = defValue;
        if (cursor.moveToNext()) {
            try {
                ret = cursor.getInt(0);
            } catch (Exception e) {

            }
        }
        cursor.close();
        return ret;
    }

    /**
     * 使用insert方法插入数据到SkProvider进程的SP
     *
     * @param context
     * @param values
     * @return
     */
    private static void insert(Context context, ContentValues values) {
        context.getContentResolver().insert(CONTENT_URI, values);
    }

    public static void save(Context context, String key, String value) {
        ContentValues values = new ContentValues(1);
        values.put(key, value);
        insert(context, values);
    }

    public static void remove(Context context, String key) {
        save(context, key, null);
    }

    /**
     * 读取共享
     * SkProvider.getInt(context,PARAMETER_KEY);
     *
     * 写入共享
     * SkProvider.save(context, PARAMETER_KEY);
     */
}

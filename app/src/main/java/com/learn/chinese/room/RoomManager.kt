package com.learn.chinese.room

import android.content.Context
import android.util.Log
import com.learn.chinese.base.BaseApplication
import com.learn.chinese.bean.LearnData
import com.learn.chinese.interfaces.ICallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @Author:  Jin
 * @Description:
 * @CreateDate: 2023/7/25  11:26
 */
class RoomManager {
    companion object {
        private const val TAG = "RoomManager"

        @JvmStatic
        @Synchronized
        fun checkDb(list: List<LearnData>, callback: ICallback<List<LearnData>>?) {
            CoroutineScope(Dispatchers.IO).launch {
                val sqlDatabase = SqlDatabase.getInstance(BaseApplication.getAppContext())
                val learnInfoList = sqlDatabase.learnInfoDao().learnInfoList
                if (learnInfoList == null || learnInfoList.size == 0) {
                    for (item in list) {
                        val learnInfo = LearnInfo(item.zhName, item.enName, item.type, item.star, item.diamond)
                        sqlDatabase.learnInfoDao().insert(learnInfo)
                    }
                    Log.i(TAG, "checkDb learnInfoList == null list:${list.size}")
                    withContext(Dispatchers.Main) {
                        callback?.onDone(list)
                    }
                } else {
                    for (learnInfo in learnInfoList) {
                        for (learnData in list) {
                            if (learnData.type == learnInfo.type) {
                                Log.i(TAG, "checkDb learnInfo.type:${learnInfo.type} learnInfo.star:${learnInfo.star} learnInfo.diamond:${learnInfo.diamond}")
                                learnData.star = learnInfo.star
                                learnData.diamond = learnInfo.diamond
                                break
                            }
                        }
                    }
                    Log.i(TAG, "checkDb learnInfoList:${learnInfoList.size} list:${list.size}")
                    withContext(Dispatchers.Main) {
                        callback?.onDone(list)
                    }
                }
            }
        }

        @JvmStatic
        fun updateStarAndDiamond(type: Int, callback: ICallback<String>?) {
            CoroutineScope(Dispatchers.IO).launch {
                val sqlDatabase = SqlDatabase.getInstance(BaseApplication.getAppContext())
                val learnInfoByType = sqlDatabase.learnInfoDao().getLearnInfoByType(type)
                val star = learnInfoByType.star
                if (star >= 3) {
                    val diamond = learnInfoByType.diamond
                    if (diamond == 0) {
                        learnInfoByType.diamond = 1
                    }
                } else {
                    learnInfoByType.star = star + 1
                }
                sqlDatabase.learnInfoDao().update(learnInfoByType)
                withContext(Dispatchers.Main) {
                    callback?.onDone("")
                }
            }
        }

        @JvmStatic
        @Synchronized
        fun queryLearnInfoToDb(context: Context,callback: ICallback<List<LearnInfo>>?) {
            CoroutineScope(Dispatchers.IO).launch {
                val sqlDatabase = SqlDatabase.getInstance(context.applicationContext)
                val learnInfoList = sqlDatabase.learnInfoDao().learnInfoList
                if (learnInfoList == null)
                    Log.i(TAG, "queryLearnInfoToDb learnInfoList == null")
                if (learnInfoList != null)
                    Log.i(TAG, "queryLearnInfoToDb learnInfoList:${learnInfoList.size}")
                withContext(Dispatchers.Main) {
                    callback?.onDone(learnInfoList)
                }
            }
        }
    }
}
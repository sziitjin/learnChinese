package com.learn.chinese.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/25  10:45
 */
@Database(entities = {LearnInfo.class}, version = 1)
public abstract class SqlDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "lear_info_db";

    private static SqlDatabase databaseInstance;

    public static synchronized SqlDatabase getInstance(Context context) {
        if (databaseInstance == null) {
            databaseInstance = Room
                    .databaseBuilder(context.getApplicationContext(), SqlDatabase.class, DATABASE_NAME)
                    .build();
        }
        return databaseInstance;
    }

    public abstract LearnInfoDao learnInfoDao();
}

package com.learn.chinese.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/25  10:41
 */
@Dao
public interface LearnInfoDao {
    @Insert
    void insert(LearnInfo learnInfo);

    @Delete
    void delete(LearnInfo learnInfo);

    @Update
    void update(LearnInfo learnInfo);

    @Query("SELECT * FROM LearnInfo")
    List<LearnInfo> getLearnInfoList();

    @Query("SELECT * FROM LearnInfo WHERE id = :id")
    LearnInfo getLearnInfoById(int id);

    @Query("SELECT * FROM LearnInfo WHERE type = :type")
    LearnInfo getLearnInfoByType(int type);

}

package com.learn.chinese.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/25  10:23
 */
@Entity(tableName = "LearnInfo")
public class LearnInfo {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    public int id;

    @ColumnInfo(name = "zhName", typeAffinity = ColumnInfo.TEXT)
    public String zhName;

    @ColumnInfo(name = "enName", typeAffinity = ColumnInfo.TEXT)
    public String enName;

    @ColumnInfo(name = "type", typeAffinity = ColumnInfo.INTEGER)
    public int type;

    @ColumnInfo(name = "star", typeAffinity = ColumnInfo.INTEGER)
    public int star;

    @ColumnInfo(name = "diamond", typeAffinity = ColumnInfo.INTEGER)
    public int diamond;

    /**
     * Room会使用这个构造器来存储数据，也就是当你从表中得到LearnInfo对象时候，Room会使用这个构造器
     */
    public LearnInfo(int id, String zhName, String enName, int type, int star, int diamond) {
        this.id = id;
        this.zhName = zhName;
        this.enName = enName;
        this.type = type;
        this.star = star;
        this.diamond = diamond;
    }

    /**
     * 由于Room只能识别和使用一个构造器，如果希望定义多个构造器，你可以使用Ignore标签，让Room忽略这个构造器
     * 同样，@Ignore标签还可用于字段，使用@Ignore标签标记过的字段，Room不会持久化该字段的数据
     */
    @Ignore
    public LearnInfo(String zhName, String enName, int type, int star, int diamond) {
        this.zhName = zhName;
        this.enName = enName;
        this.type = type;
        this.star = star;
        this.diamond = diamond;
    }
}

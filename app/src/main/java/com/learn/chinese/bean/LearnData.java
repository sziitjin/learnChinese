package com.learn.chinese.bean;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/4  11:45
 */
public class LearnData {
    private String zhName;
    private String enName;
    private int type;
    private int icon;
    private int icon1;
    private int icon2;
    private int icon3;
    private int icon4;
    private int star;
    private int diamond;

    public LearnData(String zhName, String enName, int type, int icon) {
        this.zhName = zhName;
        this.enName = enName;
        this.type = type;
        this.icon = icon;
    }

    public LearnData(LearnData.Builder builder) {
        this.zhName = builder.zhName;
        this.enName = builder.enName;
        this.type = builder.type;
        this.icon = builder.icon;
        this.icon1 = builder.icon1;
        this.icon2 = builder.icon2;
        this.icon3 = builder.icon3;
        this.icon4 = builder.icon4;
        this.star = builder.star;
        this.diamond = builder.diamond;
    }

    public String getZhName() {
        return zhName;
    }

    public void setZhName(String zhName) {
        this.zhName = zhName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getDiamond() {
        return diamond;
    }

    public void setDiamond(int diamond) {
        this.diamond = diamond;
    }

    public int getIcon1() {
        return icon1;
    }

    public int getIcon2() {
        return icon2;
    }

    public int getIcon3() {
        return icon3;
    }

    public int getIcon4() {
        return icon4;
    }

    public static final class Builder {
        private String zhName;
        private String enName;
        private int type;
        private int icon;
        private int icon1;
        private int icon2;
        private int icon3;
        private int icon4;
        private int star;
        private int diamond;

        public Builder() {
        }

        public Builder(String zhName, String enName, int type, int icon) {
            this.zhName = zhName;
            this.enName = enName;
            this.type = type;
            this.icon = icon;
        }

        public LearnData build() {
            return new LearnData(this);
        }

        public Builder addIcon1(int icon1) {
            this.icon1 = icon1;
            return this;
        }

        public Builder addIcon2(int icon2) {
            this.icon2 = icon2;
            return this;
        }

        public Builder addIcon3(int icon3) {
            this.icon3 = icon3;
            return this;
        }

        public Builder addIcon4(int icon4) {
            this.icon4 = icon4;
            return this;
        }

    }
}

package com.learn.chinese.bean;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/26  16:03
 */
public class RankingBean {
    private String name;
    private int icon;
    private String iconUrl;
    private int star;
    private int diamond;
    private int ranking;

    public RankingBean(String name, int icon, int star, int diamond, int ranking) {
        this.name = name;
        this.icon = icon;
        this.star = star;
        this.diamond = diamond;
        this.ranking = ranking;
    }

    public RankingBean(String name, int icon, String iconUrl, int star, int diamond, int ranking) {
        this.name = name;
        this.icon = icon;
        this.iconUrl = iconUrl;
        this.star = star;
        this.diamond = diamond;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
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

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}

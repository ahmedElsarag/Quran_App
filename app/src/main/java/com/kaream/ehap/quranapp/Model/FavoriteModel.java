package com.kaream.ehap.quranapp.Model;

public class FavoriteModel {
    public String serverName;
    public String realName;
    public String StateName;
    public String ImgUrl;
    public int imgDrawable;
    public String RecitesName = "";
    public String RecitesAYA = "";
    public String RealNameForReader = "";

    public FavoriteModel() {
    }

    public FavoriteModel(String serverName, String realName) {
        this.serverName = serverName;
        this.realName = realName;
    }

    public FavoriteModel(String serverName, String realName, String stateName, String imgUrl, int imgDrawable, String recitesAYA, String recitesName, String realNameForReader) {
        this.serverName = serverName;
        this.realName = realName;
        StateName = stateName;
        ImgUrl = imgUrl;
        this.imgDrawable = imgDrawable;
        this.RecitesAYA = recitesAYA;
        this.RecitesName = recitesName;
        this.RealNameForReader = realNameForReader;
    }
}

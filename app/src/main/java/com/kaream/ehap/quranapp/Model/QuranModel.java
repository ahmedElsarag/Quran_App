package com.kaream.ehap.quranapp.Model;

public class QuranModel {


    public String serverName;
    public String realName;
    public String StateName;
    public String ImgUrl;
    public int ImgDownload ;


    public QuranModel() {

    }

    public QuranModel(String serverName, String realName) {
        this.serverName = serverName;
        this.realName = realName;
    }

    public QuranModel(String serverName, String realName, String stateName, String imgUrl , int ImgDownload) {
        this.serverName = serverName;
        this.realName = realName;
        this.StateName = stateName;
        this.ImgUrl = imgUrl;
        this.ImgDownload = ImgDownload ;
    }
}

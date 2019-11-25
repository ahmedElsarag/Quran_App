package com.kaream.ehap.quranapp.Model;

public class ReaderModel {

    public String realName;
    public String serverName;
    public int imgDrawable;


    public ReaderModel() {
    }

    public ReaderModel(String serverName, String realName) {
        this.realName = realName;
        this.serverName = serverName;
    }

    public ReaderModel(String serverName, String realName, int imgDrawable) {
        this.realName = realName;
        this.serverName = serverName;
        this.imgDrawable = imgDrawable;

    }
}

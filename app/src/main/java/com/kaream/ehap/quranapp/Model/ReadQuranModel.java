package com.kaream.ehap.quranapp.Model;

public class ReadQuranModel {

    public String pathImage;
    public int postion;
    public String nameItemList;
    public int imageSouraType;

    public ReadQuranModel() {

    }

    public ReadQuranModel(String pathImage, int postion, String nameItemList, int imageSouraType) {
        this.pathImage = pathImage;
        this.postion = postion;
        this.nameItemList = nameItemList;
        this.imageSouraType = imageSouraType;
    }

    public ReadQuranModel(String pathImage, int postion, String nameItemList) {
        this.pathImage = pathImage;
        this.postion = postion;
        this.nameItemList = nameItemList;

    }


    public ReadQuranModel(String pathImage) {
        this.pathImage = pathImage;
    }


}

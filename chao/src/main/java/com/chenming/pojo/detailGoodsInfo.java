package com.chenming.pojo;

import java.util.ArrayList;

public class detailGoodsInfo {
    private GoodsInfo goodsInfo;
    private ArrayList<String> pictureAddress;

    public GoodsInfo getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public ArrayList<String> getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(ArrayList<String> pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    @Override
    public String toString() {
        return "detailGoodsInfo{" +
                "goodsInfo=" + goodsInfo +
                ", pictureAddress=" + pictureAddress +
                '}';
    }

    public detailGoodsInfo(GoodsInfo goodsInfo, ArrayList<String> pictureAddress) {
        this.goodsInfo = goodsInfo;
        this.pictureAddress = pictureAddress;
    }
    public detailGoodsInfo(){}
}

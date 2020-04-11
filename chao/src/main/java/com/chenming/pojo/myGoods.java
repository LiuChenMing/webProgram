package com.chenming.pojo;

import java.util.ArrayList;

public class myGoods {
    private int goodsNum;
    private ArrayList<detailGoodsInfo> detailGoodsInfos;

    public myGoods(int goodsNum, ArrayList<detailGoodsInfo> detailGoodsInfos) {
        this.goodsNum = goodsNum;
        this.detailGoodsInfos = detailGoodsInfos;
    }
    public myGoods(){}

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public ArrayList<detailGoodsInfo> getDetailGoodsInfos() {
        return detailGoodsInfos;
    }

    public void setDetailGoodsInfos(ArrayList<detailGoodsInfo> detailGoodsInfos) {
        this.detailGoodsInfos = detailGoodsInfos;
    }

    @Override
    public String toString() {
        return "myGoods{" +
                "goodsNum=" + goodsNum +
                ", detailGoodsInfos=" + detailGoodsInfos +
                '}';
    }
}

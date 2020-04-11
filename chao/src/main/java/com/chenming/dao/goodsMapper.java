package com.chenming.dao;

import com.chenming.pojo.GoodsInfo;
import com.chenming.pojo.detailGoodsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface goodsMapper {
    public int insertGoodsDetail(@Param("imgAddress")String imgAddress,@Param("goodsId")String goodsId);
    public int insertGoodsBasicInfo(GoodsInfo goodsinfo);
    public ArrayList<detailGoodsInfo> getDetailGoodsInfoByuserId(String userId);
    public ArrayList<String> selectAddressById(String goodsId);
    public int deleteGoodsByGoodsId(String goodsId);
}

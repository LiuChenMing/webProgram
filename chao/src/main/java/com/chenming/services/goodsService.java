package com.chenming.services;

import com.chenming.dao.goodsMapper;
import com.chenming.pojo.GoodsInfo;
import com.chenming.pojo.detailGoodsInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class goodsService {
    //图片文件存储地址
    private static String UPLOAD_DIRECTORY="/myApp/imageData";

    @Autowired
    goodsMapper goodsmapper;

    @Transactional
    public String insertGoodsInfo(MultipartFile[] imageInput, GoodsInfo goodsInfo, HttpServletRequest request) throws IOException {


        if(imageInput==null)
            return "error";

        //获取userId
        for (Cookie cookie :
                request.getCookies()) {
            if (cookie.getName().equals("userId"))
                goodsInfo.setUserId(cookie.getValue());
        }

        //先插入基本信息
        if(goodsmapper.insertGoodsBasicInfo(goodsInfo)==0)
            return "error";
        //获取刚刚插入的记录的主键
        String primaryKey=goodsInfo.getGoodsId();

        System.out.println(goodsInfo.toString());

        System.out.println("uuid:"+primaryKey);
        for(int i=0;i<imageInput.length;i++){

            Date date=new Date(System.currentTimeMillis());
            SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd-HH_mm_ss_SSS");

            String address=UPLOAD_DIRECTORY+"/"+primaryKey+dateFormat.format(date);

            File dest=new File(address);
            if(!dest.exists()){
                dest.mkdirs();
            }
            String simpleAddress="/imageData/"+primaryKey+dateFormat.format(date);
            goodsmapper.insertGoodsDetail(simpleAddress,primaryKey);
            imageInput[i].transferTo(dest);
        }
        return "success";
    }

    public String getDetailGoodsInfo(HttpServletRequest request) throws JsonProcessingException {
        String userId=null;
        for (Cookie c :
                request.getCookies()) {
            if (c.getName().equals("userId"))
                userId=c.getValue();
        }
        ArrayList<detailGoodsInfo> detailGoodsInfos=goodsmapper.getDetailGoodsInfoByuserId(userId);

        ObjectMapper objectMapper=new ObjectMapper();

        return objectMapper.writeValueAsString(detailGoodsInfos);
    }

    @Transactional
    public String deleteGoods(String goodsId){
        ArrayList<String> t=goodsmapper.selectAddressById(goodsId);


        if(goodsmapper.deleteGoodsByGoodsId(goodsId)==1){
            for (String s :
                    t) {
                String address="/myApp"+s;
                File file=new File(address);
                file.delete();
            }

            return "success";
        }
        else
            return "error";
    }
    @Transactional
    public String updateGoodsInfo(MultipartFile[] imageInput, GoodsInfo goodsInfo, HttpServletRequest request) throws IOException {

        //先获得需要删除的商品的id
        String goodsId=goodsInfo.getGoodsId();

        System.out.println("将被删除的商品的id为："+goodsId);

        String status1=insertGoodsInfo(imageInput,goodsInfo,request);

        String status2=deleteGoods(goodsId);

        if(status1.equals("success")&&status2.equals("success"))
            return "success";
        else
            return "error";
    }
}

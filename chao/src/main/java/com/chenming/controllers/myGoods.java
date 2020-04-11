package com.chenming.controllers;

import com.chenming.pojo.GoodsInfo;
import com.chenming.services.goodsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class myGoods {
    @Autowired
    private goodsService service;

    @RequestMapping(path = {"/goodsInfo"},method = {RequestMethod.POST})
    @ResponseBody
    public String goodsInfoReceiver(MultipartFile[] imageInput, GoodsInfo goodsInfo, HttpServletRequest request) throws IOException {
        return service.insertGoodsInfo(imageInput,goodsInfo,request);
    }

    @ResponseBody
    @RequestMapping("/getGoodsInfo")
    public String getGoodsInfo(HttpServletRequest request) throws JsonProcessingException {
        return service.getDetailGoodsInfo(request);
    }

    @RequestMapping(path = "/deleteGoods",method = RequestMethod.POST)
    @ResponseBody
    public String deleteGoods(String goodsId){
        return service.deleteGoods(goodsId);
    }

    @ResponseBody
    @RequestMapping(value = "/updateGoodsInfo",method =RequestMethod.POST )
    public String updateGoodsInfo(MultipartFile[] imageInput, GoodsInfo goodsInfo, HttpServletRequest request) throws IOException {
        return service.updateGoodsInfo(imageInput,goodsInfo,request);
    }
}

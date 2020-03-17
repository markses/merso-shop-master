package org.merso.mersoshop.controller;

import org.merso.mersoshop.entity.Shops;

import org.merso.mersoshop.repository.ShopsRepository;

import org.merso.mersoshop.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopController {
@Autowired
private ShopsRepository shopsRepository;
    //获取首页商品
    @RequestMapping("/getshops")
    public ResponseData getshops() {
        List<Shops> shopsList =  shopsRepository.findAll();
        ResponseData responseData = new ResponseData();
        responseData.setData(shopsList);
        return responseData;

    }
}

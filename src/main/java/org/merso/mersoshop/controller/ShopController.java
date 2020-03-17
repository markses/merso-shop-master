package org.merso.mersoshop.controller;

import org.merso.mersoshop.entity.Shops;

import org.merso.mersoshop.repository.ShopsRepository;

import org.merso.mersoshop.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/books")
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

    //获取商品详情
    @RequestMapping(value = "/details",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getdatails(@RequestParam("sid") Integer sid) {
        Shops shops = shopsRepository.findBySid(sid);
        ResponseData responseData = new ResponseData();
        responseData.setData(shops);
        return responseData;
    }

}

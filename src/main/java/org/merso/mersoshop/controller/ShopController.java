package org.merso.mersoshop.controller;

import lombok.Data;
import org.merso.mersoshop.entity.Shops;

import org.merso.mersoshop.entity.ShopsSpecValue;
import org.merso.mersoshop.repository.ShopsRepository;

import org.merso.mersoshop.repository.ShopsSpecValueRepository;
import org.merso.mersoshop.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/shops")
public class ShopController {
@Autowired
private ShopsRepository shopsRepository;
@Autowired
private ShopsSpecValueRepository shopsSpecValueRepository;
    //获取手机
    @RequestMapping("/getiphones")
    public ResponseData getshops() {
        List<Shops> shopsList =  shopsRepository.getIphones();
        ResponseData responseData = new ResponseData();
        responseData.setData(shopsList);
        //return shopsList;
        return responseData;

    }

    //获取商品详情
    @RequestMapping(value = "/details",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getdatails(@RequestParam("id") Integer id) {
        Optional<Shops> shops = shopsRepository.findById(id);
        //List<ShopsSpecValue> shopsSpecValue = shopsSpecValueRepository.getShopsSpecValue(id);
        ResponseData responseData = new ResponseData();
        //responseData.setShopsSpecValues(shopsSpecValue);
        responseData.setData(shops);
        return responseData;
    }

  //获取电脑信息 getcomputers
  @RequestMapping("/getcomputers")
  public ResponseData getComputer() {
      List<Shops> shopsList =  shopsRepository.getComputers();
      ResponseData responseData = new ResponseData();
      responseData.setData(shopsList);
      //return shopsList;
      return responseData;

  }

  //获取衣服信息
  @RequestMapping("/getshops")
  public ResponseData getShops() {
      List<Shops> shopsList =  shopsRepository.getShops();
      ResponseData responseData = new ResponseData();
      responseData.setData(shopsList);
      //return shopsList;
      return responseData;

  }
    @RequestMapping("/getfoods")
    public ResponseData getFoods() {
        List<Shops> shopsList =  shopsRepository.getFoods();
        ResponseData responseData = new ResponseData();
        responseData.setData(shopsList);
        //return shopsList;
        return responseData;

    }

    //获取优惠商品信息
    @RequestMapping("/getLowShops")
    public ResponseData getLowShops() {
        List<Shops> shopsList = shopsRepository.getLowShops();
        ResponseData responseData = new ResponseData();
        responseData.setData(shopsList);
        //return shopsList;
        return responseData;
    }

    //搜索商品
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getSearchShops(@RequestParam("name") String name) {
        List<Shops> shopsList = shopsRepository.findByName(name);
        ResponseData responseData = new ResponseData();
        responseData.setCode(300);
        responseData.setData(shopsList);
        //return shopsList;
        return responseData;
    }
}

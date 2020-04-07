package org.merso.mersoshop.controller;

import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.merso.mersoshop.entity.Shops;

import org.merso.mersoshop.entity.ShopsSpecValue;
import org.merso.mersoshop.repository.ShopsRepository;

import org.merso.mersoshop.repository.ShopsSpecValueRepository;
import org.merso.mersoshop.result.ResponseData;
import org.merso.mersoshop.service.ShopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
@Autowired
private ShopsService shopsService;
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
        //List<ShopsSpecValue> shopsSpecValue = shopsSpecValueRepository.getValue(id);
        ResponseData responseData = new ResponseData();
       // responseData.setShopsSpecValues(shopsSpecValue);
        responseData.setData(shops);
        responseData.setShopsSpecValues(shopsService.getSize(id));
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

    @RequestMapping(value = "/get")
    @ResponseBody
    public ResponseData getSize(){
        ResponseData responseData = new ResponseData();
        responseData.setData(shopsRepository.findAll());
        return responseData;
    }

    //更新商品上架状态
    @RequestMapping(value = "/updatePublishStatus",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData updatePublishStatus(@RequestParam("sku_no") String sku_no, @RequestParam("is_put") Boolean is_put){
        ResponseData responseData = new ResponseData();
        shopsRepository.updatePublishStatus(sku_no,is_put);
        responseData.setMsg("更改状态成功");
        return responseData;


    }

    //删除商品
    @RequestMapping(value = "handleDeleteShops",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData handleDeleteShops(@RequestParam("sku_no") String sku_no) {
        ResponseData responseData = new ResponseData();
        shopsRepository.DeleteShops(sku_no);
        responseData.setMsg("删除成功");
        return responseData;
    }
}

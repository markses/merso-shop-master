package org.merso.mersoshop.controller;


import org.merso.mersoshop.repository.ShopsCategoryRepository;
import org.merso.mersoshop.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/category")
public class ShopsCategoryController {

    @Autowired
    private ShopsCategoryRepository shopsCategoryRepository;

    @RequestMapping(value = "/get")
    public ResponseData getCategory(){
        ResponseData responseData = new ResponseData();
        responseData.setData(shopsCategoryRepository.getCategory());
        return responseData;


    }
}

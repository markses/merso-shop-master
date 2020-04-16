package org.merso.mersoshop.service;

import org.merso.mersoshop.entity.Shops;
import org.merso.mersoshop.entity.ShopsSize;
import org.merso.mersoshop.mapper.ShopsMapper;
import org.merso.mersoshop.repository.ShopsRepository;
import org.merso.mersoshop.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sun.print.PeekGraphics;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopsService {
    @Resource
    private ShopsMapper shopsMapper;
    @Autowired
    private ShopsRepository shopsRepository;

    public List<ShopsSize> getSize(int id){
      List<ShopsSize> shopsSize = shopsMapper.getSize(id);
      return shopsSize;
    }

    // 后台添加商品
    public String ReqAddShops(Shops shops){
        Shops shops1 = shopsRepository.findSkuShops(shops.getSku_no());
        if(shops1 == null){

            shopsRepository.save(shops);
            return "添加商品成功";

        } else{
            return "请勿重复添加商品";
        }

    }
}

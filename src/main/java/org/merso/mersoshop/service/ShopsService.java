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

//    public ResponseData getShopList(){
//        PageRequest pageRequest = PageRequest.of(0,10);
//       Page<Shops> shopsPage = shopsRepository.findAll(pageRequest);
//       List<Shops> shopsList = shopsPage.getContent();
//
//       int size = shopsPage.getTotalPages();
//        ResponseData responseData = new ResponseData();
//        responseData.setData(shopsList);
//        responseData.setCode(size);
////       System.out.println(size);
////        return shopsList;
//        return responseData;
//    }
}

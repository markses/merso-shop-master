package org.merso.mersoshop.repository;

import lombok.Data;
import org.merso.mersoshop.entity.Shops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ShopsRepository  extends JpaRepository<Shops,Integer> {
    //获取手机信息
    @Query(value = "select stock,sku_details,sku_name,low_price,id,price,sku_no,category_id,sku_url from shops_sku where category_id = 1",nativeQuery = true)
    List<Shops> getIphones();
      //获取电脑信息
    @Query(value = "select stock,sku_details,sku_name,id,price,low_price,sku_no,category_id,sku_url from shops_sku where category_id = 2",nativeQuery = true)
    List<Shops> getComputers();
    //获取衣服信息
    @Query(value = "select stock,sku_details,sku_name,id,price,low_price,sku_no,category_id,sku_url from shops_sku where category_id = 3",nativeQuery = true)
    List<Shops> getShops();
    //获取零食信息
    @Query(value = "select stock,sku_details,sku_name,id,price,sku_no,low_price,category_id,sku_url from shops_sku where category_id = 4",nativeQuery = true)
    List<Shops> getFoods();
    //获取商品详情

    Optional<Shops> findById(Integer id);

    //获取优惠商品信息
    @Query(value = "select stock,sku_details,sku_name,id,price,sku_no,low_price,category_id,sku_url from shops_sku where category_id = 5",nativeQuery = true)
    List<Shops> getLowShops();

}

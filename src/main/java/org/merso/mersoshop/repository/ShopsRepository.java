package org.merso.mersoshop.repository;

import lombok.Data;
import org.merso.mersoshop.entity.OrderModel;
import org.merso.mersoshop.entity.Shops;
import org.merso.mersoshop.entity.ShopsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Repository
public interface ShopsRepository  extends JpaRepository<Shops,Integer> {
    //获取手机信息
    @Query(value = "select new org.merso.mersoshop.entity.ShopsModel(id,sku_no," +
            "sku_name,sku_details,stock,sku_url,price,low_price)" +
            " from Shops  s where s.category_id = 1")
    List<ShopsModel> getIphones();

      //获取电脑信息
      @Query(value = "select new org.merso.mersoshop.entity.ShopsModel(id,sku_no," +
              "sku_name,sku_details,stock,sku_url,price,low_price)" +
              " from Shops  s where s.category_id = 2")
    List<ShopsModel> getComputers();
    //获取衣服信息
    @Query(value = "select new org.merso.mersoshop.entity.ShopsModel(id,sku_no," +
            "sku_name,sku_details,stock,sku_url,price,low_price)" +
            " from Shops  s where s.category_id = 3")
    List<ShopsModel> getShops();
    //获取零食信息
    @Query(value = "select new org.merso.mersoshop.entity.ShopsModel(id,sku_no," +
            "sku_name,sku_details,stock,sku_url,price,low_price)" +
            " from Shops  s where s.category_id = 4")
    List<ShopsModel> getFoods();
    //获取商品详情

    Optional<Shops> findById(Integer id);

    //获取优惠商品信息
    @Query(value = "select new org.merso.mersoshop.entity.ShopsModel(id,sku_no," +
            "sku_name,sku_details,stock,sku_url,price,low_price)" +
            " from Shops  s where s.category_id = 5")
    List<ShopsModel> getLowShops();

    //搜索商品
    @Query("select s from Shops s where s.sku_details like concat('%',?1,'%') ")
    List<Shops> findByName(String name);

    //商品上架状态
    @Modifying
    @Transactional
    @Query(value = "update Shops s set s.is_put = ?2 where s.sku_no = ?1")
    void updatePublishStatus(String sku_no,Boolean is_put);


    //删除商品
    @Modifying
    @Transactional
    @Query(value = "delete from Shops  s where s.sku_no = ?1")
    void DeleteShops(String sku_no);


    //添加后台商品
    @Query(value = "select s from Shops s where s.sku_no = ?1")
    Shops findSkuShops(String sku_no);
}

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

    @Query(value = "select stock,sku_details,sku_name,id,price,sku_no,category_id from shops_sku where category_id = 4",nativeQuery = true)
    List<Shops> getShops();
    //获取商品详情
    Optional<Shops> findById(Integer id);
}

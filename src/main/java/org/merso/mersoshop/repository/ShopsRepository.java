package org.merso.mersoshop.repository;

import org.merso.mersoshop.entity.Shops;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopsRepository  extends JpaRepository<Shops,Integer> {

    //获取商品详情
    Shops findBySid(Integer sid);
}

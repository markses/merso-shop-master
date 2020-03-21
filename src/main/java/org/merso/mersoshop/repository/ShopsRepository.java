package org.merso.mersoshop.repository;

import org.merso.mersoshop.entity.Shops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShopsRepository  extends JpaRepository<Shops,Integer> {

    //获取商品详情
    Shops findBySid(Integer sid);
}

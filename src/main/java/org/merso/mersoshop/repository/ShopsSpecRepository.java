package org.merso.mersoshop.repository;

import org.merso.mersoshop.entity.ShopsSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ShopsSpecRepository extends JpaRepository<ShopsSpec,Integer> {


//        @Query(value = "select sv.spec_value,sv.id,sv.shopsSpec from ShopsSpec spe,Shops s,ShopsSkuSpec spec,ShopsSpecValue sv" +
//        " where sku.id =  spec.skuId and spec.specId = spe.id " +
//        " and sv.specId = spe.id and sku.id = ?1")
//        List<Map> getValue(Integer id);

}

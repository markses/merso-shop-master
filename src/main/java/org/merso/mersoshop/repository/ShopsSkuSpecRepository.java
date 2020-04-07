package org.merso.mersoshop.repository;

import org.merso.mersoshop.entity.OrderModel;
import org.merso.mersoshop.entity.ShopsSkuSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopsSkuSpecRepository extends JpaRepository<ShopsSkuSpec,Integer> {

//        @Query(value = "select sv.spec_value,sv.id,sv.shopsSpec from Shops sku,ShopsSkuSpec spec, spe," +
//        "ShopsSpecValue sv where sku.id =  spe.sku_id and sku.specId = spe.id " +
//        "and sv.spec_id = spe.id and sku.id = ?1")
//    List<> getValue(Integer id);

//    @Query(value = "select new org.merso.mersoshop.entity.ShopsSize()" +
//            "from Shops s,ShopsSkuSpec spec,ShopsSpec spe where s.id = spec.skuId and" +
//            " spec.specId = spe.id and sku.id = ?1")
//    List<OrderModel> getValue(Integer id);
}

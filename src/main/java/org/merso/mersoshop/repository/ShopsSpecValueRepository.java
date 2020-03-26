package org.merso.mersoshop.repository;

import org.merso.mersoshop.entity.Shops;
import org.merso.mersoshop.entity.ShopsSpecValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopsSpecValueRepository extends JpaRepository<ShopsSpecValue,Integer> {
//    @Query(value = "select sv.id,sv.spec_id,sv.spec_value from shops_sku sku right join shops_sku_spec spc on sku.id = spc.sku_id right join shops_spec_value sv on spc.spec_id = sv.spec_id where sku.id = :id",nativeQuery = true)
//    List<ShopsSpecValue> getShopsSpecValue(@Param("id")int id);


}

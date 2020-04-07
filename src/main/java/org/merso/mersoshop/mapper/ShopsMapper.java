package org.merso.mersoshop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.merso.mersoshop.entity.ShopsSize;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface ShopsMapper {
    @Select(value = "SELECT sc.spec_value,sku.sku_name\n" +
            "        FROM shops_sku sku,shops_spec spec,shops_sku_spec skp,shops_spec_value sc,shops_values ss\n" +
            "        WHERE sku.id = skp.sku_id AND spec.id = skp.spec_id AND spec.id = sc.spec_id " +
            "AND sku.id = ss.sku_id AND ss.value_id = sc.id and sku.id = #{id}")
    List<ShopsSize> getSize(@Param("id") Integer id);
}

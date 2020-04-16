package org.merso.mersoshop.repository;

import org.merso.mersoshop.entity.ShopsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopsCategoryRepository extends JpaRepository<ShopsCategory,Integer> {

    @Query(value = "select s from ShopsCategory s")
    List<ShopsCategory> getCategory();

}

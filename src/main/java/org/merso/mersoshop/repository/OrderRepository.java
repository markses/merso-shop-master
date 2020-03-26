package org.merso.mersoshop.repository;

import org.merso.mersoshop.entity.Order;
import org.merso.mersoshop.entity.Shops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    //添加订单
//    void addOrder(List<Order> order);

 //返回订单
    //List<Order> getOrder(String username);

    List<Order> findByAccount(String account);

    @Query(value = "select max(id) from orders",nativeQuery = true)
    int maxID();

    Order findBySkuId(int skuId);

//    @Query(value = "select * from orders where sid = #{sid}",nativeQuery = true)
//    Order getSid(int sid);

//    @Modifying
//    @Query("update orders count set count = count'+'ll  where u.id = ?2")
//    Integer updatePasswordById(String password, String id);
     @Query(value = "select o.count from Order o where o.skuId = ?1")
     int getCount(int skuId);

//    @Query("select u from User u where u.sex = ?1")
//    List<User> findUsersBySex(Integer sex);

     @Modifying
    @Query(value = "update Order o set o.count = ?1 where o.skuId= ?2")
    void updateCount(int count,int skuId);



}

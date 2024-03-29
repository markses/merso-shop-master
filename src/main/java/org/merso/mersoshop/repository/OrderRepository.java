package org.merso.mersoshop.repository;

import org.merso.mersoshop.entity.Order;
import org.merso.mersoshop.entity.OrderModel;
import org.merso.mersoshop.entity.SendOrderModel;
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


 //返回订单
// @Query(value = "select o.skuId,o.id,o.count,o.account,o.color,o. from Order o where o.account = ?1")
//    List<Order> getOrder(String account);

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

    @Query(value = "select new org.merso.mersoshop.entity.OrderModel(s.sku_url,s.sku_name,o.color,o.size,o.orderNo,o.id)" +
            "from User u inner join Order o on u.account = o.account inner join Shops s on o.skuId = s.id where u.account = ?1 and o.order_status = 0 ")
    List<OrderModel> getOrders(String account);

    //取消订单
//    @Modifying
//    @Transactional
//    @Query(value = "update Order o set o.send_status = 3 where o.orderNo = ?1")
    void deleteByOrderNo(String orderNo);

    //支付订单
    @Modifying
    @Query(value = "update Order o set o.order_status = 1 where o.orderNo= ?1")
    void payOrder(String orderNo);

    @Query(value = "select new org.merso.mersoshop.entity.OrderModel(s.sku_url,s.sku_name,o.color,o.size,o.orderNo,o.id)" +
            "from User u inner join Order o on u.account = o.account inner join OrderSend se on se.order_no = o.orderNo inner join " +
            "Shops s on o.skuId = s.id where u.account = ?1 and o.order_status = 1 and se.send_status = 0")
    List<OrderModel> getPayOrder(String account);

    //删除订单
    @Modifying
    @Transactional
    @Query(value = "delete from Order o where o.orderNo = ?1")
    void DeleteOrders(String orderNo);

    //支付订单
    @Modifying
    @Transactional
    @Query(value = "update Order o set o.info_id = ?1 where o.orderNo= ?2")
    void paymentOrders(int info_id,String orderNo);

    //后台订单查询
    @Query(value = "select new org.merso.mersoshop.entity.SendOrderModel(u.name,u.address,u.postal_code,u.iphone,o.orderNo)" +
            "from UserInfo u ,Order o where u.id = o.info_id and o.orderNo = ?1")
    List<SendOrderModel> getSendOrderModel(String orderNo);

    //订单状态更新
    @Modifying
    @Transactional
    @Query(value = "update Order o set o.send_status = 1 where o.orderNo= ?1")
    void updateSeOrder(String orderNo);
}



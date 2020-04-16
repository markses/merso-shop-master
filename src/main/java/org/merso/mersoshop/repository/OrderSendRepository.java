package org.merso.mersoshop.repository;

import org.merso.mersoshop.entity.OrderSend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface OrderSendRepository  extends JpaRepository<OrderSend,Integer> {

    @Query(value = "select s from OrderSend s where s.order_no = ?1")
   OrderSend SelectOrders(String order_no);

    //收货操作
    @Modifying
    @Transactional
    @Query(value = "update OrderSend o set o.send_status = 1 where o.order_no = ?1")
    void UpdateOrders(String order_no);
}

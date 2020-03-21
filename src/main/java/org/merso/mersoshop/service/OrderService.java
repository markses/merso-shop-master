package org.merso.mersoshop.service;

import org.merso.mersoshop.entity.Order;
import org.merso.mersoshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;


    public void addOrder(List<Order> orders) {
        for (int i=0;i<orders.size();i++) {
        int oid;
        try {
            oid = orderRepository.maxID() + 1;
        } catch(Exception e){
            oid = 0;
        }
        int sid = orders.get(i).getSid();
        System.out.println(sid);
        System.out.println(orders.get(i));
        if (orderRepository.findBySid(sid) == null) {

//            int stock = orderRepository.getStock(orders.get(i).getSid());
//            stock = stock - orders.get(i).getUsername();
//            if (stock >= 0) {
//                orderRepository.setStock(orders.get(i).getISBN(), stock);
//                orders.get(i).setOid(oid);
//                orderRepository.addOrder((List<Order>) orders.get(i));
//            }
            orders.get(i).setOid(oid);
            orders.get(i).setUsername(orders.get(i).getUsername());
            orderRepository.save(orders.get(i));
        }else {
    int count = orderRepository.getCount(sid);
    System.out.println(count);
    count += orders.get(i).getCount();
    orderRepository.updateCount(count,sid);

        }
        }
    }

// 获取指定用户订单

//    public List<Order> getOrder(String username) {
//        List<Order> orders = orderRepository.getOrder(username);
//        return orders;
//    }
}

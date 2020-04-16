package org.merso.mersoshop.service;

import org.merso.mersoshop.entity.Order;
import org.merso.mersoshop.repository.OrderRepository;
import org.merso.mersoshop.result.OrderNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;


    public void addOrder(List<Order> orders) {
        for (int i = 0; i < orders.size(); i++) {
            int id;
            try {
                id = orderRepository.maxID() + 1;
            } catch (Exception e) {
                id = 0;
            }
            int skuId = orders.get(i).getSkuId();
            if (orderRepository.findBySkuId(skuId) == null) {


                orders.get(i).setId(id);

                orders.get(i).setOrderNo(OrderNumberUtil.GetRandom());

                orderRepository.save(orders.get(i));
            } else {
                int count = orderRepository.getCount(skuId);
                System.out.println(count);
                count += orders.get(i).getCount();
                orderRepository.updateCount(count, skuId);

            }
        }
    }

// 获取指定用户订单

//    public List<Order> getOrder(String username) {
//        List<Order> orders = orderRepository.getOrder(username);
//        return orders;
//    }
}

package org.merso.mersoshop.controller;

import org.merso.mersoshop.entity.Order;
import org.merso.mersoshop.entity.Orders;
import org.merso.mersoshop.repository.OrderRepository;
import org.merso.mersoshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/order")
public class OrderController {
@Autowired
private OrderService orderService;
@Autowired
private OrderRepository orderRepository;


    //添加订单
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public List<Order> addOrder(@RequestBody Orders orders) {
       System.out.println(orders);
        int size = orders.getOrders().size();
        System.out.println(size);
        for (int i=0;i<size;i++) {
            Date date= new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            orders.getOrders().get(i).setDate(timestamp);
        }

        orderService.addOrder(orders.getOrders());
        System.out.println(orders.getOrders());
        List<Order> result = orderRepository.findByAccount(orders.getOrders().get(0).getAccount());

        return result;
    }


}

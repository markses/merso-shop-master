package org.merso.mersoshop.controller;

import org.merso.mersoshop.entity.Order;
import org.merso.mersoshop.entity.OrderModel;
import org.merso.mersoshop.entity.Orders;
import org.merso.mersoshop.entity.SendOrderModel;
import org.merso.mersoshop.repository.OrderRepository;
import org.merso.mersoshop.result.ResponseData;
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

    @RequestMapping(value = "/getOrders", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getOrder(@RequestParam("account") String account) {
System.out.println(account);
      List<Order> orders = orderRepository.findByAccount(account);
      ResponseData responseData = new ResponseData();
      responseData.setData(orders);
      return responseData;
    }

    @RequestMapping(value = "/getOrder", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getOrders(@RequestParam("account") String account) {

      List<OrderModel> orderModels = orderRepository.getOrders(account);
        ResponseData responseData = new ResponseData();
        responseData.setData(orderModels);
        return responseData;
//        return orderModels;
    }

    @RequestMapping(value = "/deleteOrder", method = RequestMethod.GET)
    @ResponseBody
    public String deleteOrders(@RequestParam("order_no") String order_no) {
        orderRepository.deleteByOrderNo(order_no);

       return "取消成功";
    }
    //支付订单
    @RequestMapping(value = "/PayOrder", method = RequestMethod.GET)
    @ResponseBody
    public String PayOrders(@RequestParam("order_no") String order_no) {
        orderRepository.payOrder(order_no);

        return "支付成功";
    }

    //获取支付订单
    @RequestMapping(value = "/getPayOrder", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getPayOrders(@RequestParam("account") String account) {

        List<OrderModel> orderModels = orderRepository.getPayOrder(account);
        ResponseData responseData = new ResponseData();
        responseData.setData(orderModels);
        return responseData;
//        return orderModels;
    }
    //获取所有订单
    @RequestMapping(value = "/get")
    @ResponseBody
    public ResponseData getAllOrders() {


        ResponseData responseData = new ResponseData();
        responseData.setData(orderRepository.findAll());
        return responseData;

    }

    //删除订单
    @RequestMapping(value = "/handleDeleteOrders")
    @ResponseBody
    public ResponseData handleDeleteOrders(@RequestParam("orderNo") String orderNo) {


        ResponseData responseData = new ResponseData();
        orderRepository.DeleteOrders(orderNo);
        responseData.setMsg("删除成功");
        return responseData;

    }

    //支付订单
    @RequestMapping(value = "/payMentOrder")
    @ResponseBody
    public ResponseData payMentOrder(@RequestParam("orderNo") String orderNo,@RequestParam("info_id") int info_no) {


        ResponseData responseData = new ResponseData();
        orderRepository.paymentOrders(info_no,orderNo);
        responseData.setMsg("确认支付成功");
        return responseData;

    }
//后台订单查询
    @RequestMapping(value = "/sendPayOrder")
    @ResponseBody
    public ResponseData sendPayOrder (@RequestParam("orderNo") String orderNo) {

         List<SendOrderModel> sendOrderModels = orderRepository.getSendOrderModel(orderNo);

        ResponseData responseData = new ResponseData();
   responseData.setData(sendOrderModels);
        responseData.setMsg("获取成功");

        return responseData;

    }


    //发送订单状态更新
    @RequestMapping(value = "/updateSendOrder",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData updateSendOrder(@RequestParam("orderNo") String orderNo) {



        ResponseData responseData = new ResponseData();
orderRepository.updateSeOrder(orderNo);
        responseData.setMsg("更新成功");

        return responseData;

    }
}

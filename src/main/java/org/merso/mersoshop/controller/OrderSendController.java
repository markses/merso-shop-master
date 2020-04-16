package org.merso.mersoshop.controller;

import org.merso.mersoshop.entity.OrderSend;
import org.merso.mersoshop.repository.OrderRepository;
import org.merso.mersoshop.repository.OrderSendRepository;
import org.merso.mersoshop.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orderSend")
public class OrderSendController {
    @Autowired
    private OrderSendRepository orderSendRepository;

    @RequestMapping(value = "deliverySendOrder")
    @ResponseBody
    public ResponseData deliverySendOrder(@RequestBody OrderSend orderSend) {
        System.out.println(orderSend);
        ResponseData responseData = new ResponseData();
        orderSendRepository.save(orderSend);
        responseData.setMsg("发货成功");
        return responseData;
    }

    @RequestMapping(value = "selectSendOrder", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData selectSendOrder(@RequestParam("order_no") String order_no) {

        ResponseData responseData = new ResponseData();
        OrderSend orderSend = orderSendRepository.SelectOrders(order_no);
        responseData.setData(orderSend);
        responseData.setMsg("发货成功");
        return responseData;
    }

    //收货操作
    @RequestMapping(value = "handUpdaSendStatus", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData handUpdaSend(@RequestParam("order_no") String order_no) {

        ResponseData responseData = new ResponseData();
       orderSendRepository.UpdateOrders(order_no);

        responseData.setMsg("收货成功");
        return responseData;
    }
}

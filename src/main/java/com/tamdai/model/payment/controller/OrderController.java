package com.tamdai.model.payment.controller;

import com.tamdai.model.payment.entity.OrderPayment;
import com.tamdai.model.payment.service.OrderPaymentService;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class OrderController {

    @Autowired
    OrderPaymentService orderPaymentService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "create/order", method = RequestMethod.POST)
    public OrderPayment OrderPaymentCreate(@RequestBody OrderPayment orderPayment,
                                           @RequestParam("userId") Long id, BindingResult bindingResult) {
        UserEntity user = userService.getUserId(id);
        return orderPaymentService.OrderPaymentCreate(orderPayment, user);
    }

    @RequestMapping(value = "get/orderAll", method = RequestMethod.GET)
    public List<OrderPayment> getOrderPaymentAll() {
        return orderPaymentService.getOrderPaymentAll();
    }


    @RequestMapping(value = "getOrder/{id}", method = RequestMethod.GET)
    public OrderPayment getOrderById(@PathVariable("id") Long id) {
        return orderPaymentService.getOrderById(id);
    }
}


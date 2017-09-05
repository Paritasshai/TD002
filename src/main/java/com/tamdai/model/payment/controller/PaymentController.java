package com.tamdai.model.payment.controller;

import com.tamdai.model.payment.entity.PaymentTransaction;
import com.tamdai.model.payment.service.PaymentService;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "create/payment", method = RequestMethod.POST)
    public PaymentTransaction paymentCreate(@RequestBody PaymentTransaction payment,
                                            @RequestParam("userId") Long id, BindingResult bindingResult) {
        UserEntity user = userService.getUserId(id);
        return paymentService.paymentCreate(payment, user);
    }

    @RequestMapping(value = "get/paymentAll", method = RequestMethod.GET)
    public List<PaymentTransaction> getPaymentAll() {
        return paymentService.getPaymentAll();
    }

}


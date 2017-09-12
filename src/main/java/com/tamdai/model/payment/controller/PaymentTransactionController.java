package com.tamdai.model.payment.controller;

import com.tamdai.model.payment.entity.PaymentTransaction;
import com.tamdai.model.payment.service.PaymentTransactionService;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class PaymentTransactionController {

    @Autowired
    PaymentTransactionService paymentTransactionService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "createTransaction", method = RequestMethod.POST)
    @ResponseBody
    public PaymentTransaction createTransaction(HttpServletRequest request,
                                                @RequestBody PaymentTransaction paymentTransaction,
                                                HttpServletResponse response, @RequestParam("Email") String email,
                                                @RequestParam("transRef") String transRef) {
        UserEntity user = userService.getUserByEmail(email);
        return paymentTransactionService.createPaymentTransaction(user, paymentTransaction, transRef);
    }

    @RequestMapping(value = "get/PaymentTransaction", method = RequestMethod.GET)
    public List<PaymentTransaction> getPatmentTransaction() {
        return paymentTransactionService.getPaymentTransaction();
    }
}

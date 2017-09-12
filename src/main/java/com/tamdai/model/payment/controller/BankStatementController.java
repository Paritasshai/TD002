package com.tamdai.model.payment.controller;

import com.tamdai.model.payment.entity.BankStatement;
import com.tamdai.model.payment.entity.PaymentTransaction;
import com.tamdai.model.payment.service.BankStatementService;
import com.tamdai.model.payment.service.PaymentTransactionService;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class BankStatementController {

    @Autowired
    UserService userService;

    @Autowired
    BankStatementService bankStatementService;

    @Autowired
    PaymentTransactionService paymentTransactionService;

    @RequestMapping(value = "create/bankStatement", method = RequestMethod.POST)
    public BankStatement bankStatementCreate(@RequestBody BankStatement bankStatement,
                                             @RequestParam("userId") Long id, BindingResult bindingResult) {
        UserEntity user = userService.getUserId(id);
        return bankStatementService.bankStatementCreate(bankStatement, user);
    }

    @RequestMapping(value = "get/bankStatement", method = RequestMethod.GET)
    public List<BankStatement> getBankStatementAll() {
        return bankStatementService.getBankStatementAll();
    }

    @RequestMapping(value = "get/bankStatement/{id}", method = RequestMethod.GET)
    public BankStatement getBankStatementById(@PathVariable("id") Long id) {
        return bankStatementService.getBankStatementById(id);
    }

    @RequestMapping(value = "update/bankStatement/{id}", method = RequestMethod.PUT)
    public BankStatement bankStatementUpdate(@PathVariable("id") Long id,
                                             HttpServletRequest request,
                                             @RequestBody BankStatement bankStatement,
                                             @RequestParam("Email") String email,
                                             @RequestParam("UserId") Long userId,
                                             @RequestParam("transRef") String transRef,
                                             @RequestParam("Balance") String balance, BindingResult bindingResult) {
        UserEntity user = userService.getUserByEmail(email);
        BankStatement bank = bankStatementService.getBankStatementById(id);

        try {
            PaymentTransaction paymentTransaction = new PaymentTransaction();

            //CreateDate
            String signUpDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            paymentTransaction.setCreateDate(signUpDate);

            //CreateTime
            String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
            paymentTransaction.setCreateTime(timeStamp);

            String transAmount = new String(balance);
            paymentTransaction.setTransAmount(transAmount);

            paymentTransactionService.createPaymentTransaction(user, paymentTransaction, transRef);

//            userService.addPaymentTransaction(user, paymentTransaction);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bankStatementService.bankStatementUpdate(bankStatement, user, balance, bank);
    }

}

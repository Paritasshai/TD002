package com.tamdai.model.payment.controller;

import com.tamdai.model.payment.entity.BankStatement;
import com.tamdai.model.payment.service.BankStatementService;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class BankStatementController {

    @Autowired
    UserService userService;

    @Autowired
    BankStatementService bankStatementService;

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
                                             @RequestBody BankStatement bankStatement,
                                             @RequestParam("FirstName") String firstName,
                                             @RequestParam("UserId") Long userId,
                                             @RequestParam("Balance") String balance, BindingResult bindingResult) {
//        UserEntity user = userService.getUserId(userId);
        UserEntity user = userService.getUserByFirstName(firstName);
        BankStatement bank = bankStatementService.getBankStatementById(id);
        return bankStatementService.bankStatementUpdate(bankStatement, user, balance, bank);
    }

}

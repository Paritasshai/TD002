package com.tamdai.model.payment.service;

import com.tamdai.model.payment.entity.BankStatement;
import com.tamdai.model.security.entity.UserEntity;

import java.math.BigDecimal;
import java.util.List;

public interface BankStatementService {
    BankStatement bankStatementCreate(BankStatement bankStatement, UserEntity user);

    List<BankStatement> getBankStatementAll();

    BankStatement getBankStatementById(Long id);

    BankStatement bankStatementUpdate(BankStatement bankStatement, UserEntity user, String balance, BankStatement bank);

}

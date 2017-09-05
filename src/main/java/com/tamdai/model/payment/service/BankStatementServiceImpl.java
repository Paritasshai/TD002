package com.tamdai.model.payment.service;

import com.tamdai.model.payment.dao.BankStatementDao;
import com.tamdai.model.payment.entity.BankStatement;
import com.tamdai.model.security.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BankStatementServiceImpl implements BankStatementService {

    @Autowired
    BankStatementDao bankStatementDao;

    @Override
    public BankStatement bankStatementCreate(BankStatement bankStatement, UserEntity user) {
        return bankStatementDao.bankStatementCreate(bankStatement, user);
    }

    @Override
    public List<BankStatement> getBankStatementAll() {
        return bankStatementDao.getBankStatementAll();
    }

    @Override
    public BankStatement getBankStatementById(Long id) {
        return bankStatementDao.getBankStatementById(id);
    }

    @Override
    public BankStatement bankStatementUpdate(BankStatement bankStatement, UserEntity user, String balance, BankStatement bank) {
        return bankStatementDao.bankStatementUpdate(bankStatement, user, balance, bank);
    }
}

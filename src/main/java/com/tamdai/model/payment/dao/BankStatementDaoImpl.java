package com.tamdai.model.payment.dao;

import com.tamdai.model.payment.entity.BankStatement;
import com.tamdai.model.payment.repository.BankStatementRepository;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class BankStatementDaoImpl implements BankStatementDao {

    @Autowired
    BankStatementRepository bankStatementRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public BankStatement bankStatementCreate(BankStatement bankStatement, UserEntity user) {

        //statusBank
        bankStatement.setStatusBank("รอการยืนยัน");

        //CreateDate
        String createDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        bankStatement.setCreateDate(createDate);

        //CreateTime
        String createTime = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
        bankStatement.setCreateTime(createTime);

        bankStatement.getUsers().add(user);
        bankStatementRepository.save(bankStatement);
        return bankStatement;
    }

    @Override
    public List<BankStatement> getBankStatementAll() {
        return bankStatementRepository.findAll();
    }

//    @Override
//    public BankStatement bankStatementUpdate(BankStatement bankStatement, VideoEntity user, String balance) {
//        bankStatement.getUsers().add(user);
//        bankStatementRepository.save(bankStatement);
//        userRepository.save(user);
//        return bankStatement;
//    }

    @Override
    public BankStatement getBankStatementById(Long id) {
        return bankStatementRepository.findOne(id);
    }

    @Override
    public BankStatement bankStatementUpdate(BankStatement bankStatement, UserEntity user, String balance, BankStatement bank) {

        //setStatusBank
        String status = new String("confirm");
        bank.setStatusBank(status);

        //updateBank
        bank.getUsers().add(user);
        bankStatementRepository.save(bank);

        user.setBalance(balance);
        userRepository.save(user);

        return bank;
    }
}

package com.tamdai.model.payment.dao;

import com.tamdai.model.payment.entity.PaymentTransaction;
import com.tamdai.model.payment.repository.PaymentTransactionRepository;
import com.tamdai.model.security.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentDaoImpl implements PaymentDao {

    @Autowired
    PaymentTransactionRepository paymentTransactionRepository;

    @Override
    public PaymentTransaction paymentCreate(PaymentTransaction payment, UserEntity user) {
        payment.getUsers().add(user);
        paymentTransactionRepository.save(payment);
        return payment;
    }

    @Override
    public List<PaymentTransaction> getPaymentAll() {
        return paymentTransactionRepository.findAll();
    }
}

package com.tamdai.model.payment.dao;

import com.tamdai.model.payment.entity.PaymentTransaction;
import com.tamdai.model.payment.repository.PaymentTransactionRepository;
import com.tamdai.model.security.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentTransactionDaoImpl implements PaymentTransactionDao {

    @Autowired
    PaymentTransactionRepository paymentTransactionRepository;


    @Override
    public List<PaymentTransaction> getPaymentTransaction() {
        return paymentTransactionRepository.findAll();
    }

    @Override
    public PaymentTransaction createPaymentTransaction(UserEntity user, PaymentTransaction paymentTransaction, String transRef) {
        paymentTransaction.getUsers().add(user);
        paymentTransactionRepository.save(paymentTransaction);
        return paymentTransaction;
    }

    @Override
    public PaymentTransaction createPaymentTransactionPurchase(UserEntity userEntity, PaymentTransaction paymentTransaction) {
        paymentTransaction.getUsers().add(userEntity);
        paymentTransactionRepository.save(paymentTransaction);
        return paymentTransaction;
    }
}

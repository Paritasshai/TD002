package com.tamdai.model.payment.dao;

import com.tamdai.model.payment.entity.PaymentTransaction;
import com.tamdai.model.security.entity.UserEntity;

import java.util.List;

public interface PaymentDao {

    PaymentTransaction paymentCreate(PaymentTransaction payment, UserEntity user);

    List<PaymentTransaction> getPaymentAll();
}

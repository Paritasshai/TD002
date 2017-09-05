package com.tamdai.model.payment.service;

import com.tamdai.model.payment.entity.PaymentTransaction;
import com.tamdai.model.security.entity.UserEntity;

import java.util.List;

public interface PaymentService {

    PaymentTransaction paymentCreate(PaymentTransaction payment, UserEntity user);

    List<PaymentTransaction> getPaymentAll();
}

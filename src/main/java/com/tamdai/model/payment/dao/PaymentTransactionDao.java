package com.tamdai.model.payment.dao;

import com.tamdai.model.payment.entity.PaymentTransaction;
import com.tamdai.model.security.entity.UserEntity;

import java.util.List;

public interface PaymentTransactionDao {

    List<PaymentTransaction> getPaymentTransaction();

    PaymentTransaction createPaymentTransaction(UserEntity user, PaymentTransaction paymentTransaction, String transRef);

    PaymentTransaction createPaymentTransactionPurchase(UserEntity userEntity, PaymentTransaction paymentTransaction);
}

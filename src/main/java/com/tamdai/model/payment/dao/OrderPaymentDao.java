package com.tamdai.model.payment.dao;

import com.tamdai.model.payment.entity.OrderPayment;
import com.tamdai.model.security.entity.UserEntity;

import java.util.List;

public interface OrderPaymentDao {

    OrderPayment paymentCreate(OrderPayment payment, UserEntity user);

    List<OrderPayment> getOrderPaymentAll();

    OrderPayment getPaymentId(Long paymentId);

    OrderPayment getOrderById(Long id);
}

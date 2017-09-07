package com.tamdai.model.payment.dao;

import com.tamdai.model.payment.entity.OrderPayment;
import com.tamdai.model.payment.repository.OrderPaymentRepository;
import com.tamdai.model.security.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderPaymentDaoImpl implements OrderPaymentDao {

    @Autowired
    OrderPaymentRepository orderPaymentRepository;

    @Override
    public OrderPayment paymentCreate(OrderPayment payment, UserEntity user) {
        payment.getUsers().add(user);
        orderPaymentRepository.save(payment);
        return payment;
    }

    @Override
    public List<OrderPayment> getOrderPaymentAll() {
        return orderPaymentRepository.findAll();
    }

    @Override
    public OrderPayment getPaymentId(Long paymentId) {
        return orderPaymentRepository.findOne(paymentId);
    }

    @Override
    public OrderPayment getOrderById(Long id) {
        return orderPaymentRepository.findOne(id);
    }
}

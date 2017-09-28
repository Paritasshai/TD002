package com.tamdai.model.payment.service;

import com.tamdai.model.payment.dao.OrderPaymentDao;
import com.tamdai.model.payment.entity.OrderPayment;
import com.tamdai.model.security.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderPaymentServiceImpl implements OrderPaymentService {

    @Autowired
    OrderPaymentDao orderPaymentDao;

    @Override
    public OrderPayment OrderPaymentCreate(OrderPayment payment, UserEntity user) {

        //CreateDate
        String createDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        payment.setCreateDate(createDate);

        //CreateTime
        String createTime = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
        payment.setCreateTime(createTime);

        //CreateStatus
        String status = new String("wait");
        payment.setStatusOrder(status);

        //PaymentId
        String accountId = UUID.randomUUID().toString();
        payment.setTransRef(accountId);

        return orderPaymentDao.paymentCreate(payment, user);
    }

    @Override
    public List<OrderPayment> getOrderPaymentAll() {
        return orderPaymentDao.getOrderPaymentAll();
    }

    @Override
    public OrderPayment getPaymentId(Long paymentId) {
        return orderPaymentDao.getPaymentId(paymentId);
    }

    @Override
    public OrderPayment getOrderById(Long id) {
        return orderPaymentDao.getOrderById(id);
    }
}

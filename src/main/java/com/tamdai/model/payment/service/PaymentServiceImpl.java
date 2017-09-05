package com.tamdai.model.payment.service;

import com.tamdai.model.payment.dao.PaymentDao;
import com.tamdai.model.payment.entity.PaymentTransaction;
import com.tamdai.model.security.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public PaymentTransaction paymentCreate(PaymentTransaction payment, UserEntity user) {

        //CreateDate
        String createDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        payment.setCreateDate(createDate);

        //CreateTime
        String createTime = new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());
        payment.setCreateTime(createTime);

        //PaymentId
        String accountId = UUID.randomUUID().toString();
        payment.setTransRef(accountId);

        return paymentDao.paymentCreate(payment, user);
    }

    @Override
    public List<PaymentTransaction> getPaymentAll() {
        return paymentDao.getPaymentAll();
    }
}

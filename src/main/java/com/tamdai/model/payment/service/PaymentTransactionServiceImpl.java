package com.tamdai.model.payment.service;

import com.tamdai.model.payment.dao.PaymentTransactionDao;
import com.tamdai.model.payment.entity.PaymentTransaction;
import com.tamdai.model.security.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PaymentTransactionServiceImpl implements PaymentTransactionService {

    @Autowired
    PaymentTransactionDao paymentTransactionDao;

    @Override
    public List<PaymentTransaction> getPaymentTransaction() {
        return paymentTransactionDao.getPaymentTransaction();
    }

    @Override
    public PaymentTransaction createPaymentTransaction(UserEntity user, PaymentTransaction paymentTransaction, String transRef) {

        //CreateDate
        String signUpDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        paymentTransaction.setUpdateDate(signUpDate);

        //CreateTime
        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
        paymentTransaction.setUpdateTime(timeStamp);

        //setFlq
        Long flq = new Long(+1);
        paymentTransaction.setTransFlq(Math.toIntExact(flq));

        //setTransRef
        String tRef = new String(transRef);
        paymentTransaction.setTransRef(tRef);

        return paymentTransactionDao.createPaymentTransaction(user, paymentTransaction, transRef);
    }
}

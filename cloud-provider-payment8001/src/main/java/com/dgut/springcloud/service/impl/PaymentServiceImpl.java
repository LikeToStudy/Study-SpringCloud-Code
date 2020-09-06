package com.dgut.springcloud.service.impl;

import com.dgut.springcloud.dao.PaymentDao;
import com.dgut.springcloud.entities.Payment;
import com.dgut.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @atuhor:
 * @date: 2020-04-28  15:41
 */
@Service("PaymentService")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentDao.getPaymentById(id);
    }
}

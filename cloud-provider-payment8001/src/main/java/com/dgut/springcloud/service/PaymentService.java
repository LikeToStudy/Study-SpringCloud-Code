package com.dgut.springcloud.service;

import com.dgut.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @atuhor:
 * @date: 2020-04-28  15:39
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") long id);
}

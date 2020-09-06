package com.dgut.springcloud.dao;

import com.dgut.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @atuhor: LZA
 * @date: 2020-04-28  15:16
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") long id);
}

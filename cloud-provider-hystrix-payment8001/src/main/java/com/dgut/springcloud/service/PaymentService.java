package com.dgut.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @atuhor:
 * @date: 2020-05-15  00:06
 */
public interface PaymentService {
    public String paymentInfo_OK(Integer id);
    public String paymentInfo_TimeOut(Integer id);
    public String paymentCircuitBreaker(@PathVariable("id") Integer id);
}

package com.dgut.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @atuhor:
 * @date: 2020-05-17  22:03
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----------------PaymentFallbackService fallback paymentInfo_OK , ( o_O )";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----------------PaymentFallbackService fallback paymentInfo_TimeOut , ( o_O )";
    }
}

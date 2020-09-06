package com.dgut.springcloud.service;

import com.dgut.springcloud.entities.CommonResult;
import com.dgut.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @atuhor:
 * @date: 2020-05-24  19:10
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentServiceFallback.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);

}

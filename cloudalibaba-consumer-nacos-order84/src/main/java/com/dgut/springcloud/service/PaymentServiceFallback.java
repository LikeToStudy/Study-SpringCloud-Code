package com.dgut.springcloud.service;

import com.dgut.springcloud.entities.CommonResult;
import com.dgut.springcloud.entities.Payment;
import com.dgut.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @atuhor:
 * @date: 2020-05-24  19:13
 */
@Component
public class PaymentServiceFallback implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"出错啦，服务降级啦 ~~~ ( o_O ) ",new Payment(id,"errorSerial"));
    }

}

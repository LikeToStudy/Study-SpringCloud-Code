package com.dgut.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @atuhor:
 * @date: 2020-05-11  20:40
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value="/payment/consul")
    public String PaymentConsul(){
        return "springcloud with consul:" + serverPort +"\t"+ UUID.randomUUID().toString();
    }
}

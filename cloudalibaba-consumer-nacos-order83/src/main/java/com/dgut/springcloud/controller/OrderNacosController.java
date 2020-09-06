package com.dgut.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @atuhor:
 * @date: 2020-05-21  15:10
 */
@RestController
@Slf4j
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    public String SERVICE_URL;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String getPaymentInfo(@PathVariable("id") Long id){
        return restTemplate.getForObject(SERVICE_URL+"/payment/nacos/"+id,String.class);
    }
}

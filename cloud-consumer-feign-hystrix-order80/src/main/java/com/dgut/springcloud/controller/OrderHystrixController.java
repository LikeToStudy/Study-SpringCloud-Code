package com.dgut.springcloud.controller;

import com.dgut.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @atuhor:
 * @date: 2020-05-17  12:14
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5;
        try { TimeUnit.SECONDS.sleep(timeNumber); }catch (InterruptedException e){ e.printStackTrace();}
        return "线程池： " + Thread.currentThread().getName() + "  payment_OK ; id :" + id + "\t" + "耗时 + " + timeNumber + "s";
    }
    public String paymentInfo_TimeOutHandler(Integer id){
        return "我是消费者80啊    /(T_T)/    调用支付接口超时或者异常：\t"+"\t当前线程池名字"+ Thread.currentThread().getName();
    }

    /**
     *  全局 fallback 方法
     */
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试， / ( T _ T ) /";
    }
}

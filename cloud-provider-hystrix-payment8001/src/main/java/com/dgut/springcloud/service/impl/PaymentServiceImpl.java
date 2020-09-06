package com.dgut.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.dgut.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @atuhor:
 * @date: 2020-05-15  00:07
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "  payment_OK ; id :" + id + "\t" + "哈哈";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 3;
        try { TimeUnit.SECONDS.sleep(timeNumber); }catch (InterruptedException e){ e.printStackTrace();}
        return "线程池： " + Thread.currentThread().getName() + "  payment_OK ; id :" + id + "\t" + "耗时 + " + timeNumber + "s";
    }
    public String paymentInfo_TimeOutHandler(Integer id){
        return "(T_T)/ 调用支付接口超时或者异常：\t"+"\t当前线程池名字"+ Thread.currentThread().getName();
    }

    /**
     *      服务熔断
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),  // 是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),    // 请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  // 时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")   // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("------id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" +"调用成功，流水号：" + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试 ( o_O ) , ID :" + id;
    }
}

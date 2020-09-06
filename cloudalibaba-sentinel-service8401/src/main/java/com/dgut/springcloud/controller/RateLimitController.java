package com.dgut.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dgut.springcloud.entities.CommonResult;
import com.dgut.springcloud.entities.Payment;
import com.dgut.springcloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @atuhor:
 * @date: 2020-05-24  16:50
 */
@RestController
public class RateLimitController {

    @GetMapping(value = "/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource()
    {
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }
    public CommonResult handleException(BlockException exception)
    {
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl()
    {
        return new CommonResult(200,"按url限流测试OK",new Payment(2020L,"serial002"));
    }

    @GetMapping(value = "/byCustomer")
    @SentinelResource(value = "byCustomer",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "byCustomerHandleException")
    public CommonResult byCustomer()
    {
        return new CommonResult(200,"按客户自定义限流测试OK",new Payment(2020L,"serial001"));
    }
}

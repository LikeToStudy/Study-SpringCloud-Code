package com.dgut.springcloud.controller;

import com.dgut.springcloud.domain.CommonResult;
import com.dgut.springcloud.domain.Order;
import com.dgut.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @atuhor:
 * @date: 2020-05-24  21:23
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }

}

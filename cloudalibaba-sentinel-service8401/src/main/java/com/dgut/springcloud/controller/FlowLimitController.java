package com.dgut.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @atuhor:
 * @date: 2020-05-24  10:35
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        try { TimeUnit.SECONDS.sleep(1); }catch (InterruptedException e){ e.printStackTrace();}
        return "------testD";
    }

    @GetMapping("/testHot")
    @SentinelResource(value = "testHot",blockHandler = "testHotError")
    public String testHot(
            @RequestParam(value = "p1",required = false) String p1,
            @RequestParam(value = "p2",required = false) String p2
        ) {
        return "------testHot";
    }
    public String testHotError(String p1, String p2, BlockException e){
        return "( o_O ) error !!!!";
    }
}

package com.dgut.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dgut.springcloud.entities.CommonResult;

/**
 * @atuhor:
 * @date: 2020-05-24  17:10
 */
public class CustomerBlockHandler {

    public static CommonResult byCustomerHandleException(BlockException exception)
    {
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }
}

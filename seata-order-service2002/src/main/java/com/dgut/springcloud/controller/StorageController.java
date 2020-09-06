package com.dgut.springcloud.controller;

import com.dgut.springcloud.domain.CommonResult ;
import com.dgut.springcloud.service.StorageService ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @atuhor:
 * @date: 2020-05-24  21:52
 */

@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;


    //扣减库存
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }

}

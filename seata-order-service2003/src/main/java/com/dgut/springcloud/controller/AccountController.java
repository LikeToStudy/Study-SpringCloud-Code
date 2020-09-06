package com.dgut.springcloud.controller;

import com.dgut.springcloud.domain.CommonResult ;
import com.dgut.springcloud.service.AccountService ;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @atuhor:
 * @date: 2020-05-24  22:07
 */
@RestController
public class AccountController {
    @Resource
    AccountService accountService;

    /**
     * 扣减账户余额
     */
    @PostMapping(value = "/account/decrease")
    public CommonResult decrease(@RequestParam(value = "userId") Long userId, @RequestParam(value = "money") BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResult(200,"扣减账户余额成功！");
    }

}

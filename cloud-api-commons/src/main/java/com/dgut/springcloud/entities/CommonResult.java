package com.dgut.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @atuhor:
 * @date: 2020-05-01  12:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String  msg;
    private T       data;

    public CommonResult(Integer code,String msg){
        this(code,msg,null);
    }
}

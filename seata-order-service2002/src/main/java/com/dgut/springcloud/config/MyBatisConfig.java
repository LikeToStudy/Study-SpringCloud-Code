package com.dgut.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @atuhor:
 * @date: 2020-05-24  21:53
 */
@Configuration
@MapperScan({"com.dgut.springcloud.dao"})
public class MyBatisConfig {
}

package com.dgut.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @atuhor:
 * @date: 2020-05-18  17:01
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/configInfo")
    public String getConfigInfo(){
        return "configInfo : " + configInfo + "\t" + "server-port : " + port;
    }
}

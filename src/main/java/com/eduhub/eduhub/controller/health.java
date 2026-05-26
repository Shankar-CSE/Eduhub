package com.eduhub.eduhub.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class health {

    @GetMapping("/")
    public String root(){
        return "Eduhub project is loading";
    }

    private final Environment environment;

    @Value("${spring.application.name}")
    private String Appname;

    public health(Environment environment){
        this.environment = environment;
    }

    @GetMapping("/env")
    public String getEnvironment(){
        String port = environment.getProperty("server.port");
        return "App_name:" + Appname + ", port:" + port;
    }

    @GetMapping("health")
    public String helloworld(){
        String port = environment.getProperty("server.port");
        return "Winter is Coming........" + "App_name:" + Appname + ", port:" + port;
    }



}

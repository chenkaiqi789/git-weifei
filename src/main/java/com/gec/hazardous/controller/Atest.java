package com.gec.hazardous.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Atest {

    @RequestMapping("/hello")
    public String Ate(){
        return "你好";
    }
}

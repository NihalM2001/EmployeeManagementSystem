package com.retailcloud.ems.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public String Hello(){
        return "Hello world!";
    }
}

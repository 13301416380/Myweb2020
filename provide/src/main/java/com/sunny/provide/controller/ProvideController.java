package com.sunny.provide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/* @RequestMapping 返回json和xml
 * @RequestMapping = @Controller + @ResponseBody
 * @Controller 返回视图html
* */
@RequestMapping

public class ProvideController {
    @GetMapping("/provide")
    public String provideContro(){
        return "GetMapping 请求!";
    }
    @RequestMapping(value = "/providerequest",method = RequestMethod.GET)
    public String providerequest(){
        return "RequestMapping 请求!";
    }
}

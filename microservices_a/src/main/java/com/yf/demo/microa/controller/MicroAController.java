package com.yf.demo.microa.controller;

import com.alibaba.fastjson.JSONObject;
import com.yf.demo.microa.feign.MicroBApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author yvan
 * @CreateDate 2022/11/15 17:05
 */
@RestController
@RequestMapping("/microa")
public class MicroAController {

    //暴露给b
    @GetMapping("/test1/V1")
    public Object aTest1(){
        JSONObject o = new JSONObject();
        o.put("a_test1","hahahahahaha");
        return o;
    }

    //调用b
    @Resource
    MicroBApi microBApi;
    @GetMapping("/test2/V1")
    public Object aTest2(){
        Object o1 = microBApi.bTest1();
        JSONObject o = new JSONObject();
        o.put("a_test2",o1);
        return o;
    }
}

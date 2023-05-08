package com.yf.demo.microb.controller;

import com.alibaba.fastjson.JSONObject;
import com.yf.demo.microb.feign.MicroAApi;
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
@RequestMapping("/microb")
public class MicroBController {
    //暴露给a
    @GetMapping("/test1/V1")
    public Object bTest1(){
        JSONObject o = new JSONObject();
        o.put("b_test1","kukukukukuku");
        return o;
    }

    //调用a
    @Resource
    MicroAApi microAApi;
    @GetMapping("/test2/V1")
    public Object bTest2(){
        Object o1 = microAApi.aTest1();
        JSONObject o = new JSONObject();
        o.put("b_test2",o1);
        return o;
    }
}

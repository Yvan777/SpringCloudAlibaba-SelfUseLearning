package com.yf.demo.microa.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.yf.demo.microa.business.service.MBankListServer;
import com.yf.demo.microa.business.service.MBankListServerPlus;
import com.yf.demo.microa.feign.MicroBApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
//    @GetMapping("/test1/V1")
    @RequestMapping(value = "/test1/V1", method = RequestMethod.GET)
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

    @Resource
    MBankListServer mBankListServer;
    @GetMapping("/test3/V1")
    public Object aTest3(){
        Integer count = mBankListServer.countMbankList();
        JSONObject o = new JSONObject();
        o.put("MBankListCount",count);
        return o;
    }

    @Resource
    MBankListServerPlus mBankListServerplus;
    @GetMapping("/test4/V1")
    public Object aTest4(){
        Integer count = mBankListServerplus.countMbankListPlus();
        JSONObject o = new JSONObject();
        o.put("MBankListCount",count);
        return o;
    }
}

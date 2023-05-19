package com.yff.demo.nacos.config.controller;

import com.alibaba.fastjson.JSONObject;
import com.yff.demo.nacos.config.service.SentinelServerl;
import com.yff.demo.nacos.config.sync.SyncValueProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @Description
 * @Author yvan
 * @CreateDate 2022/11/15 17:05
 */
@RestController
@RequestMapping("/config")
@RefreshScope //刷新配置文件
public class NacosConfigController {

//    第二种方式获取nacos的值 @Value
    @Value("${user.name}")
    private String name;
    @Value("${user.age}")
    private String age;

    @RequestMapping("/get/V1")
    public Object testGet(){
        JSONObject o = new JSONObject();
        o.put("name",name);
        o.put("age",age);
        return o;
    }

//    第三种方式获取nacos的值 基本同第二种 只不过先在配置文件配置好
//    这里去测试一下最终配置文件读取的是哪个配置文件的值
    @Resource
    private SyncValueProperties nacosConfig;
    @RequestMapping("/get/V2")
    public Object testGet2(){
        JSONObject o = new JSONObject();
        String userName = nacosConfig.getUserName();
        String userAge = nacosConfig.getUserAge();
        String userFather = nacosConfig.getUserFather();
        String userMother = nacosConfig.getUserMother();
        String userBro = nacosConfig.getUserBro();
        o.put("userName",userName);
        o.put("userAge",userAge);
        o.put("userFather",userFather);
        o.put("userMother",userMother);
//        看配置文件的refresh还是根据这个类的刷新为准
//        配置文件配了不刷新,但是类配了刷新 最终结果是以类的为准
        o.put("userBro",userBro);
        return o;
    }

    //测试熔断
    @GetMapping("/test1/V1")
    public Object test1(){
        int i = new Random().nextInt(100);
        if(i>70){
            throw new RuntimeException("test exception !!!");
        }
        JSONObject o = new JSONObject();
        o.put("test1","nacos-config访问成功了 ");
        return o;
    }

    @Resource
    SentinelServerl sentinelServerl;
    //测试熔断 -- 自定义注解
    @GetMapping("/test1/V2")
    public String test2(){
        JSONObject o = new JSONObject();
        return sentinelServerl.sentinelTest("xx");
    }
}

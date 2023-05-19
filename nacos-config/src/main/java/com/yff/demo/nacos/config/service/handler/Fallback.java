package com.yff.demo.nacos.config.service.handler;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @Author yvan
 * @CreateDate 2023/5/17 16:14
 */
@Slf4j
public class Fallback {
    // 要求：
    // 1 当前方法的返回值和参数要跟原方法一致
    // 2 参数列表的最后，允许添加一个Throwable参数，用来接收原方法中发生的异常
    // 3 需要用static修饰
    public static String fallback(String name, Throwable throwable) {
        log.error("Throwable: {}", throwable.getMessage());
        return "Throwable";
    }

}

package com.yf.demo.microa.business.service.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @Author yvan
 * @CreateDate 2023/5/17 16:12
 */
@Slf4j
public class BlockHandler {
    // 要求：
    // 1 当前方法的返回值和参数要跟原方法一致
    // 2 参数列表的最后，允许添加一个BlockException参数，用来接收原方法中发生的Sentinel异常
    // 3 需要用static修饰
    public static String  blockHandler(String name, BlockException e) {
        log.error("BlockException: {}", e.getClass().getSimpleName());
        return "BlockException";
    }
}

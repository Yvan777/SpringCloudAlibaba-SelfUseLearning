package com.yff.demo.nacos.config.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yff.demo.nacos.config.service.SentinelServerl;
import com.yff.demo.nacos.config.service.handler.BlockHandler;
import com.yff.demo.nacos.config.service.handler.Fallback;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yvan
 * @CreateDate 2023/5/17 16:08
 */
@Service
public class SentinelServerImpl implements SentinelServerl {

    int i = 0;

    @SentinelResource(value = "demoResource1",
            blockHandlerClass = BlockHandler.class,
            blockHandler = "blockHandler",
            fallbackClass = Fallback.class,
            fallback = "fallback")
//blockHandler：针对违反Sentinel控制台配置规则时触发BlockException异常时对应处理的属性
//fallback：针对Java本身出现的异常进行处理的对应属性。
    public String sentinelTest(String name) {
        i++;
        // 模拟业务异常
        if (i % 3 == 0) {
            throw new RuntimeException("异常");
        }
        return "ok";
    }

}

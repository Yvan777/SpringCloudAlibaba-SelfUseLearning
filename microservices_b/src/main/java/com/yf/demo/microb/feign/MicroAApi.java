package com.yf.demo.microb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description
 * @Author yvan
 * @CreateDate 2022/11/15 17:05
 */
@FeignClient(name="microservicesA")
public interface MicroAApi {
    @GetMapping("/microa/test1/V1")
    Object aTest1();
}

package com.yf.demo.microa.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description
 * @Author yvan
 * @CreateDate 2022/11/15 17:05
 */
@FeignClient(name="microsv-b")
public interface MicroBApi {
    @GetMapping("/microb/test1/V1")
    Object bTest1();
}

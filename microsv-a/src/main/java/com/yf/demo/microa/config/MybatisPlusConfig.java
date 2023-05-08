package com.yf.demo.microa.config;

import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description
 * @Author yvan
 * @CreateDate 2023/5/4 12:45
 */
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {
//
//    /**
//     * 注册分页插件
//     * @return
//     */
//    @Bean
//    public Interceptor paginationInterceptor() {
//        return new PaginationInterceptor();
//    }
//
//    /**
//     * 注册乐观锁插件
//     * 取出记录时，获取当前version
//     * 更新时，带上这个version
//     * 执行更新时， set version = yourVersion+1 where version = yourVersion
//     * 如果version不对，就更新失败
//     * @return
//     */
//    @Bean
//    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
//        return new OptimisticLockerInterceptor();
//    }
//
//    /**
//     * 注册主键生成策略
//     * @return
//     */
//    @Bean
//    public OracleKeyGenerator oracleKeyGenerator(){
//        return new OracleKeyGenerator();
//    }
}


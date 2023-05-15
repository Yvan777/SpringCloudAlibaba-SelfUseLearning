package com.yff.demo.nacos.config.sync;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author yvan
 * @CreateDate 2023/5/12 16:49
 */
@RefreshScope
@Data
@Component
@ConfigurationProperties(SyncValueProperties.PREFIX)
public class SyncValueProperties {
    public static final String PREFIX="sync";

    @Value("${user.name}")
    private String userName;

    @Value("${user.age}")
    private String userAge;

    @Value("${user.father}")
    private String userFather;

    @Value("${user.mother}")
    private String userMother;

    @Value("${user.bro}")
    private String userBro;

}
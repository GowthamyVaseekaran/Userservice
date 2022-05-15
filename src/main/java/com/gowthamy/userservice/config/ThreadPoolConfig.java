package com.gowthamy.userservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
@ConfigurationProperties(prefix = "user.create.thread")
@Getter @Setter
public class ThreadPoolConfig {
    private int size;
    private int maxPoolSize;
    private int keepAliveTimeInMinutes;
    private int queueSize;
}

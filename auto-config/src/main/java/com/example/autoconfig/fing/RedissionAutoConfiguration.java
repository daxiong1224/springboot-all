package com.example.autoconfig.fing;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 在spring-security module做了测试
 */
@ConditionalOnClass(Redisson.class) // 使用条件注解，只有当依赖了Redisson时才加载到容器
@EnableConfigurationProperties(RedissonProperties.class) // 加载配置参数类
@Configuration //
public class RedissionAutoConfiguration {
    @Bean // 实例化RedissonClient对象
    public RedissonClient redissonClient(RedissonProperties redissonProperties) {
        Config config = new Config();
        String prefix = redissonProperties.isSsl() ? "rediss://" : "redis://";
        String host = redissonProperties.getHost();
        int port = redissonProperties.getPort();
        int timeout = redissonProperties.getTimeout();
        config.useSingleServer()
                .setAddress(prefix + host + ":" + port)
                .setTimeout(timeout);
        return Redisson.create(config);
    }
}

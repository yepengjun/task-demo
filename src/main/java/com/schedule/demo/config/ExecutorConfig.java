package com.schedule.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author xiaolong
 * @description:
 * @date 2022/6/14-11:12 下午
 */
@Configuration
@EnableAsync
public class ExecutorConfig {

    @Bean
    public Executor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("task-schedule-");
        executor.setMaxPoolSize(100);
        executor.setCorePoolSize(50);
        executor.setQueueCapacity(100);
        executor.setKeepAliveSeconds(1000);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}

package com.hst.learninghub.configuration;

import com.hst.learninghub.configuration.properties.AppProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class SchedulerConfig implements SchedulingConfigurer {
    private final AppProperties appProperties;

    public SchedulerConfig(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

        threadPoolTaskScheduler.setPoolSize(appProperties.getScheduler().getPoolSize());
        threadPoolTaskScheduler.setThreadNamePrefix("CALCULATE-SCHEDULED-TASK-POOL-");
        threadPoolTaskScheduler.initialize();

        scheduledTaskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
    }
}

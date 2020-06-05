package com.hst.learninghub.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private AuthProperties auth;
    private SchedulerProperties scheduler;
}

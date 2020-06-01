package com.hst.learninghub.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private Auth auth;
    private Scheduler scheduler;

    @Data
    public static class Auth {
        private String tokenSecret;
        private long expirDate;
    }

    @Data
    public static class Scheduler {
        private int poolSize;
    }
}

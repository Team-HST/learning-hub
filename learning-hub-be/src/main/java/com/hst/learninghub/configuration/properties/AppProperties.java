package com.hst.learninghub.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private Auth auth;

    @Data
    public static class Auth {
        private String tokenSecret;
        private long expirDate;
    }
}

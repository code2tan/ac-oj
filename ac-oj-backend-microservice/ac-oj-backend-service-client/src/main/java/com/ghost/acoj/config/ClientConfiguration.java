package com.ghost.acoj.config;

import feign.RequestInterceptor;

// @Configuration
public class ClientConfiguration {

    // @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            template.header("group", "AC_OJ");
        };
    }
}
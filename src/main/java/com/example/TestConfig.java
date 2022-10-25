package com.example;

import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.http.HttpRequestParser;
import org.springframework.cloud.sleuth.instrument.web.HttpServerRequestParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean(HttpServerRequestParser.NAME)
    public HttpRequestParser sleuthHttpServerRequestParser(Tracer tracer) {
        return (request, context, span) -> {
            tracer.createBaggage("1", "1");
            tracer.createBaggage("2", "2");
            tracer.createBaggage("3", "3");
        };
    }

}

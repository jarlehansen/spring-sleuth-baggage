package com.example.springsleuthbaggage

import org.springframework.cloud.sleuth.Tracer
import org.springframework.cloud.sleuth.http.HttpRequestParser
import org.springframework.cloud.sleuth.instrument.web.HttpServerRequestParser
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Configuration
class TestConfig {
    @Bean(HttpServerRequestParser.NAME)
    fun sleuthHttpServerRequestParser(tracer: Tracer): HttpRequestParser {
        return HttpRequestParser { _, _, _ ->
            tracer.createBaggage("1", "1")
            tracer.createBaggage("2", "2")
            tracer.createBaggage("3", "3")
        }
    }
}

@RestController
class TestController(private val tracer: Tracer) {

    @GetMapping
    fun get() = tracer.allBaggage
}
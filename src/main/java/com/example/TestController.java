package com.example;

import java.util.Map;

import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final Tracer tracer;

    public TestController(Tracer tracer) {
        this.tracer = tracer;
    }

    @GetMapping
    public Map<String, String> get() {
        return tracer.getAllBaggage();
    }

}

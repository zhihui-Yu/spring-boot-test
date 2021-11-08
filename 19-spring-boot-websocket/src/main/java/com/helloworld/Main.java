package com.helloworld;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@SpringBootApplication
@RestController
public class Main {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(Main.class);
    @Value("${server.port}")
    public String serverPort;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping(value = "/hello")
    public String hello() {
        logger.info("call hello");
        return "hello-world, port=" + serverPort;
    }
}

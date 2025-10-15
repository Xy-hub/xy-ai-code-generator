package com.xy.aicodegenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class XyAiCodeGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyAiCodeGeneratorApplication.class, args);
    }

}

package com.xy.aicodegenerator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.xy.aicodegenerator.mapper")
public class XyAiCodeGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyAiCodeGeneratorApplication.class, args);
    }

}

package com.xy.aicodegenerator.config;

import com.aliyun.oss.*;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 阿里云OSS 配置类
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "oss.client")
public class OssConfig {

    private String host;
    private String region;
    private String bucket;
    private String endpoint;
    private String accessKey;
    private String secretKey;

    @Bean
    public OSS ossClient() {
        return OSSClientBuilder.create()
                .endpoint(endpoint)
                .region(region)
                .credentialsProvider(new DefaultCredentialProvider(accessKey, secretKey))
                .build();
    }
}

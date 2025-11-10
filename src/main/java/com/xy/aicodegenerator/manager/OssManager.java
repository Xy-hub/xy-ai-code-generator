package com.xy.aicodegenerator.manager;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.xy.aicodegenerator.config.OssConfig;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.File;

@Slf4j
@Component
public class OssManager {

    @Resource
    private OSS ossClient;

    @Resource
    private OssConfig ossConfig;

    /**
     * 上传文件
     * @param key
     * @param file
     * @return
     */
    public PutObjectResult putObject(String key, File file) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(ossConfig.getBucket(), key, file);
        return ossClient.putObject(putObjectRequest);
    }

    public String uploadFile(String key, File file) {
        PutObjectResult result = putObject(key, file);
        if (result != null) {
            String url = String.format("%s/%s",ossConfig.getHost(), key);
            log.info("文件上传成功: {} -> {}",file.getName(), url);
            return url;
        } else {
            log.info("文件上传失败");
            return null;
        }
    }
}

package com.xy.aicodegenerator.ai.model;

import dev.langchain4j.model.output.structured.Description;
import lombok.Data;

/**
 * 用于接收AI创建的应用名称的结构化实体类，因为配置了AI必须返回JSON格式，所以需要一个类进行接收，不能直接使用String接收返回值
 */
@Description("生成 应用名称 的结果")
@Data
public class AppNameResult {
    @Description("应用名称")
    private String appName;
}

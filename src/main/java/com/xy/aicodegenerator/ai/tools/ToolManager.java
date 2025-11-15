package com.xy.aicodegenerator.ai.tools;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class ToolManager {

    /**
     * 会根据组件名自动注入实现类
     */
    @Resource
    private final Map<String, BaseTool> toolMap = new ConcurrentHashMap<>();

    @Resource
    private BaseTool[] tools;


    /**
     * 根据工具名称获取工具
     * @param toolName
     * @return
     */
    public BaseTool getTool(String toolName) {
        return toolMap.get(toolName);
    }

    /**
     * 获取已注册的工具实例
     * @return
     */
    public BaseTool[] getAllTools() {
        return tools;
    }
}

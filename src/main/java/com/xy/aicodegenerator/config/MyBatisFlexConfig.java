package com.xy.aicodegenerator.config;

import com.mybatisflex.core.audit.AuditManager;
import com.mybatisflex.core.audit.ConsoleMessageCollector;
import com.mybatisflex.core.audit.MessageCollector;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

/**
 * MyBatis-Flex配置类
 */
@Configuration
public class MyBatisFlexConfig {

    /**
     * 启用SQL审计功能，将SQL语句打印到控制台
     */
    @PostConstruct
    public void enableSqlAudit() {
        // 开启审计功能
        AuditManager.setAuditEnable(true);
        
        // 设置SQL审计收集器，将SQL输出到控制台
        MessageCollector collector = new ConsoleMessageCollector();
        AuditManager.setMessageCollector(collector);
    }
}
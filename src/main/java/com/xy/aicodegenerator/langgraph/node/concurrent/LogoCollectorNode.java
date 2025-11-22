package com.xy.aicodegenerator.langgraph.node.concurrent;

import com.xy.aicodegenerator.langgraph.model.ImageCollectionPlan;
import com.xy.aicodegenerator.langgraph.model.ImageResource;
import com.xy.aicodegenerator.langgraph.state.WorkflowContext;
import com.xy.aicodegenerator.langgraph.tools.LogoGeneratorTool;
import com.xy.aicodegenerator.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.bsc.langgraph4j.action.AsyncNodeAction;
import org.bsc.langgraph4j.prebuilt.MessagesState;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LogoCollectorNode {

    public static AsyncNodeAction<MessagesState<String>> create() {
        return AsyncNodeAction.node_async(state -> {
            WorkflowContext context = WorkflowContext.getContext(state);
            List<ImageResource> logos = new ArrayList<>();
            try {
                ImageCollectionPlan plan = context.getImageCollectionPlan();
                if (plan != null && plan.getLogoTasks() != null) {
                    LogoGeneratorTool logoTool = SpringContextUtil.getBean(LogoGeneratorTool.class);
                    log.info("开始并发生成Logo，任务数: {}", plan.getLogoTasks().size());
                    for (ImageCollectionPlan.LogoTask task : plan.getLogoTasks()) {
                        List<ImageResource> images = logoTool.generateLogos(task.description());
                        if (images != null) {
                            logos.addAll(images);
                        }
                    }
                    log.info("Logo生成完成，共生成 {} 张图片", logos.size());
                }
            } catch (Exception e) {
                log.error("Logo生成失败: {}", e.getMessage(), e);
            }
            context.setLogos(logos);
            context.setCurrentStep("Logo生成");
            return WorkflowContext.saveContext(context);
        });
    }
}

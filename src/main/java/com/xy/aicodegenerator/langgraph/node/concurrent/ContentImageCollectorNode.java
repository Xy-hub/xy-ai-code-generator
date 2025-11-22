package com.xy.aicodegenerator.langgraph.node.concurrent;

import com.xy.aicodegenerator.langgraph.model.ImageCollectionPlan;
import com.xy.aicodegenerator.langgraph.model.ImageResource;
import com.xy.aicodegenerator.langgraph.state.WorkflowContext;
import com.xy.aicodegenerator.langgraph.tools.ImageSearchTool;
import com.xy.aicodegenerator.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.bsc.langgraph4j.action.AsyncNodeAction;
import org.bsc.langgraph4j.prebuilt.MessagesState;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ContentImageCollectorNode {

    public static AsyncNodeAction<MessagesState<String>> create() {
        return AsyncNodeAction.node_async(state -> {
            WorkflowContext context = WorkflowContext.getContext(state);
            List<ImageResource> contentImages = new ArrayList<>();
            try {
                ImageCollectionPlan plan = context.getImageCollectionPlan();
                if (plan != null && plan.getContentImageTasks() != null) {
                    ImageSearchTool imageSearchTool = SpringContextUtil.getBean(ImageSearchTool.class);
                    log.info("开始并发收集内容图片，任务数: {}", plan.getContentImageTasks().size());
                    for (ImageCollectionPlan.ImageSearchTask task : plan.getContentImageTasks()) {
                        List<ImageResource> images = imageSearchTool.searchContentImages(task.query());
                        if (images != null) {
                            contentImages.addAll(images);
                        }
                    }
                    log.info("内容图片收集完成，共收集到 {} 张图片", contentImages.size());
                }
            } catch (Exception e) {
                log.error("内容图片收集失败: {}", e.getMessage(), e);
            }
            // 将收集到的图片存储到上下文的中间字段中
            context.setContentImages(contentImages);
            context.setCurrentStep("内容图片收集");
            return WorkflowContext.saveContext(context);
        });
    }
}

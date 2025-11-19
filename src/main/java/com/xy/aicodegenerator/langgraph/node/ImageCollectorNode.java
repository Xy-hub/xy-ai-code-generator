package com.xy.aicodegenerator.langgraph.node;

import com.xy.aicodegenerator.langgraph.model.ImageResource;
import com.xy.aicodegenerator.langgraph.model.enums.ImageCategoryEnum;
import com.xy.aicodegenerator.langgraph.state.WorkflowContext;
import lombok.extern.slf4j.Slf4j;
import org.bsc.langgraph4j.action.AsyncNodeAction;
import org.bsc.langgraph4j.prebuilt.MessagesState;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class ImageCollectorNode {
    public static AsyncNodeAction<MessagesState<String>> create() {
        return AsyncNodeAction.node_async(state -> {
            WorkflowContext context = WorkflowContext.getContext(state);
            log.info("执行节点: 图片收集");
            
            // TODO: 实际执行图片收集逻辑
            
            // 简单的假数据
            List<ImageResource> imageList = Arrays.asList(
                ImageResource.builder()
                    .category(ImageCategoryEnum.CONTENT)
                    .description("假数据图片1")
                    .url("https://www.codefather.cn/logo.png")
                    .build(),
                ImageResource.builder()
                    .category(ImageCategoryEnum.LOGO)
                    .description("假数据图片2")
                    .url("https://www.codefather.cn/logo.png")
                    .build()
            );
            
            // 更新状态
            context.setCurrentStep("图片收集");
            context.setImageList(imageList);
            log.info("图片收集完成，共收集 {} 张图片", imageList.size());
            return WorkflowContext.saveContext(context);
        });
    }
}

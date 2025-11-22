package com.xy.aicodegenerator.langgraph.node;

import com.xy.aicodegenerator.langgraph.ai.ImageCollectionService;
import com.xy.aicodegenerator.langgraph.model.ImageResource;
import com.xy.aicodegenerator.langgraph.model.enums.ImageCategoryEnum;
import com.xy.aicodegenerator.langgraph.state.WorkflowContext;
import com.xy.aicodegenerator.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.bsc.langgraph4j.action.AsyncNodeAction;
import org.bsc.langgraph4j.prebuilt.MessagesState;

import java.util.Arrays;
import java.util.List;

/**
 * 图片收集节点
 * 使用AI进行工具调用，收集不同类型的图片
 */
@Slf4j
public class ImageCollectorNode {

    public static AsyncNodeAction<MessagesState<String>> create() {
        return AsyncNodeAction.node_async(state -> {
            WorkflowContext context = WorkflowContext.getContext(state);
            /*
              TODO
              修改originalPrompt， 原提示词是创建一个XXX网站，图片收集节点可能不会根据这个提示词进行搜集图片，应该先调用AI得知你想创建什么类型的网站，然后返回应该搜索什么类型的图片，然后
              再使用图片搜集工具再根据AI返回的提示词去搜索相关图片
             */
            String originalPrompt = context.getOriginalPrompt();
            String imageListStr = "";
            try {
                // 获取AI图片收集服务
                ImageCollectionService imageCollectionService = SpringContextUtil.getBean(ImageCollectionService.class);
                // 使用 AI 服务进行智能图片收集
                imageListStr = imageCollectionService.collectImages(originalPrompt);
            } catch (Exception e) {
                log.error("图片收集失败: {}", e.getMessage(), e);
            }
            // 更新状态
            context.setCurrentStep("图片收集");
            context.setImageListStr(imageListStr);
            return WorkflowContext.saveContext(context);
        });
    }
}


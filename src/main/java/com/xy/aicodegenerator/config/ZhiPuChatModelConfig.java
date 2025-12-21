package com.xy.aicodegenerator.config;

import dev.langchain4j.community.model.zhipu.ZhipuAiChatModel;
import dev.langchain4j.community.model.zhipu.ZhipuAiStreamingChatModel;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
//import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "langchain4j.zhipu.chat-model")
@Data
public class ZhiPuChatModelConfig {

    private String baseUrl;

    private String apiKey;

    private String modelName;

    private Integer maxTokens;

    /**
     * 推理流式模型（用于 Vue 项目生成，带工具调用）
     */
    @Bean
    public StreamingChatModel zhiPuStreamingChatModel() {
         return ZhipuAiStreamingChatModel.builder()
                .apiKey(apiKey)
                .model(modelName)
                .maxToken(maxTokens)
                .logRequests(true)
                .logResponses(true)
                .build();
    }

    @Bean
    public ChatModel zhiPuChatModel() {
        return ZhipuAiChatModel.builder()
                .apiKey(apiKey)
                .model(modelName)
                .maxToken(maxTokens)
                .logRequests(true)
                .logResponses(true)
                .build();
    }
}

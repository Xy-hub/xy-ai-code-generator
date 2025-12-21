//package com.xy.aicodegenerator;
//
//import ai.z.openapi.ZhipuAiClient;
//import ai.z.openapi.service.model.*;
//import com.xy.aicodegenerator.ai.AiCodeGeneratorService;
//import com.xy.aicodegenerator.ai.AiCodeGeneratorServiceFactory;
//import dev.langchain4j.model.chat.StreamingChatModel;
//import jakarta.annotation.Resource;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Sinks;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.CountDownLatch;
//
//@SpringBootTest
//public class ZhipuAiTest {
//
//    @Resource
//    private StreamingChatModel zhiPuStreamingChatModel;
//
//    @Resource
//    private AiCodeGeneratorServiceFactory aiCodeGeneratorServiceFactory;
//
//    @Test
//    void test() {
//        Random random = new Random();
//        int randomInt = random.nextInt(100000) + 1; // 生成1-100000之间的正整数
//        AiCodeGeneratorService aiCodeGeneratorService = aiCodeGeneratorServiceFactory.getAiCodeGeneratorService(randomInt);
//        Flux<String> stringFlux = aiCodeGeneratorService.generateHtmlCodeStream("生成一个个人博客网站，代码不超过50行");
//
//        // 使用CountDownLatch替代Thread.sleep，更精确地控制等待
//        CountDownLatch latch = new CountDownLatch(1);
//
//        stringFlux
//                .doOnNext(chunk -> {
//                    // 处理每个代码块片段，添加空值检查
//                    if (chunk != null && !chunk.isEmpty() && !chunk.equals("null")) {
//                        System.out.print(chunk);
//                    }
//                })
//                .doOnError(error -> {
//                    // 处理错误情况
//                    System.err.println("流式处理错误: " + error.getMessage());
//                    error.printStackTrace();
//                    latch.countDown();
//                })
//                .doOnComplete(() -> {
//                    // 流式处理完成后的操作
//                    System.out.println("\n流式处理完成");
//                    latch.countDown();
//                })
//                .subscribe();
//        try {
//            latch.await();  // 等待流式处理完成
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void main(String[] args) {
//        ZhipuAiClient client = ZhipuAiClient.builder()
//                .apiKey("xxxx")
//                .build();
////        ChatMessage build = ChatMessage.builder()
////                .role(ChatMessageRole.SYSTEM.value())
////                .content("你是一位资深的 Web 前端开发专家，精通 HTML、CSS 和原生 JavaScript。你擅长构建响应式、美观且代码整洁的单页面网站。\n" +
////                        "\n" +
////                        "你的任务是根据用户提供的网站描述，生成一个完整、独立的单页面网站。你需要一步步思考，并最终将所有代码整合到一个 HTML 文件中。")
////                .build();
//        // 创建流式聊天请求
//        ChatCompletionCreateParams request = ChatCompletionCreateParams.builder()
//                .model("glm-4.6")
//                .messages(List.of(
//                        ChatMessage.builder()
//                                .role(ChatMessageRole.USER.value())
//                                .content("写一首关于春天的诗")
//                                .build()
//                ))
//                .stream(true)
//                .build();
//
//        // 处理流式响应
//        ChatCompletionResponse response = client.chat().createChatCompletion(request);
//
//        if (response.isSuccess() && response.getFlowable() != null) {
//            Flux.from(response.getFlowable())
//                    .doOnNext(data -> {
//                        if (data.getChoices() != null && !data.getChoices().isEmpty()) {
//                            Choice choice = data.getChoices().getFirst();
//                            System.out.print(choice.getDelta().getContent());
////                            if (choice.getDelta() != null && choice.getDelta().getContent() != null) {
////                                System.out.print(choice.getDelta().getContent());
////                            }
//                        }
//                    })
//                    .doOnError(error -> {
//                        System.err.println("\n 流式错误: " + error.getMessage());
//                    })
//                    .doOnComplete(() -> {
//                        System.out.println("\n 流式完成");
//                    })
//                    .subscribe();
//        }
//    }
//
//}

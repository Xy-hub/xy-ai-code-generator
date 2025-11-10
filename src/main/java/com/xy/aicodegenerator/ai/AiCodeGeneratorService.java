package com.xy.aicodegenerator.ai;


import cn.hutool.json.JSONObject;
import com.xy.aicodegenerator.ai.model.AppNameResult;
import com.xy.aicodegenerator.ai.model.HtmlCodeResult;
import com.xy.aicodegenerator.ai.model.MultiFileCodeResult;
import com.xy.aicodegenerator.model.enums.CodeGenTypeEnum;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.service.*;
import reactor.core.publisher.Flux;

public interface AiCodeGeneratorService {

    /**
     * 生成 HTML 代码
     *
     * @param userMessage 用户消息
     * @return 生成的代码结果
     */
    @SystemMessage(fromResource = "prompt/codegen-html-system-prompt.txt")
    HtmlCodeResult generateHtmlCode(String userMessage);

    /**
     * 生成多文件代码
     *
     * @param userMessage 用户消息
     * @return 生成的代码结果
     */
    @SystemMessage(fromResource = "prompt/codegen-multi-file-system-prompt.txt")
    MultiFileCodeResult generateMultiFileCode(String userMessage);

    /**
     * 生成 HTML 代码（流式）
     *
     * @param userMessage 用户消息
     * @return 生成的代码结果
     */
    @SystemMessage(fromResource = "prompt/codegen-html-system-prompt.txt")
    Flux<String> generateHtmlCodeStream(String userMessage);

    /**
     * 生成多文件代码（流式）
     *
     * @param userMessage 用户消息
     * @return 生成的代码结果
     */
    @SystemMessage(fromResource = "prompt/codegen-multi-file-system-prompt.txt")
    Flux<String> generateMultiFileCodeStream(String userMessage);

    /**
     * 生成 Vue 项目代码（流式）
     *
     * @param userMessage 用户消息
     * @return 生成过程的流式响应
     */
    @SystemMessage(fromResource = "prompt/codegen-vue-project-system-prompt.txt")
    TokenStream generateVueProjectCodeStream(@MemoryId long appId, @UserMessage String userMessage);


    /**
     * 生成应用名称
     * 因为配置了AI必须返回JSON格式，所以需要一个类进行接收，不能直接使用String接收返回值
     * @param userMessage
     * @return
     */
    @UserMessage(value = "{{message}}")
    AppNameResult createAppName(@V("message") String userMessage);

    /**
     * 根据用户需求智能选择代码生成类型
     * @param userPrompt
     * @return
     */
    @SystemMessage(fromResource = "prompt/codegen-routing-system-prompt.txt")
    CodeGenTypeEnum routeCodeGenType(@UserMessage String userPrompt);

}

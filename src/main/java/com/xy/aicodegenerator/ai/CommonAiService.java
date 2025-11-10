package com.xy.aicodegenerator.ai;


import com.xy.aicodegenerator.ai.model.AppNameResult;
import com.xy.aicodegenerator.ai.model.HtmlCodeResult;
import com.xy.aicodegenerator.ai.model.MultiFileCodeResult;
import com.xy.aicodegenerator.model.enums.CodeGenTypeEnum;
import dev.langchain4j.service.*;
import reactor.core.publisher.Flux;

/**
 * 通用AI Service类， 适用于简单的一问一答的AI对话模式
 */
public interface CommonAiService {

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
    CodeGenTypeEnum routeCodeGenType(String userPrompt);

}

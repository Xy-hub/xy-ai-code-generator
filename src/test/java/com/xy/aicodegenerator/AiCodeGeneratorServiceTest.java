package com.xy.aicodegenerator;

import com.xy.aicodegenerator.ai.AiCodeGeneratorService;
import com.xy.aicodegenerator.ai.model.HtmlCodeResult;
import com.xy.aicodegenerator.ai.model.MultiFileCodeResult;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiCodeGeneratorServiceTest {

    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    @Test
    void generateHtmlCode() {
        HtmlCodeResult htmlCodeResult = aiCodeGeneratorService.generateHtmlCode("帮我做一个个人博客网站，代码不超过50行");
        Assertions.assertNotNull(htmlCodeResult);
    }

    @Test
    void generateMultiFileCode() {
        MultiFileCodeResult multiFileCodeResult = aiCodeGeneratorService.generateMultiFileCode("帮我做一个个人网站的的留言板，代码不超过50行");
        Assertions.assertNotNull(multiFileCodeResult);
    }
}

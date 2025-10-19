package com.xy.aicodegenerator;

import com.xy.aicodegenerator.core.AiCodeGeneratorFacade;
import com.xy.aicodegenerator.model.enums.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class AiCodeGeneratorFacadeTest {

    @Resource
    private AiCodeGeneratorFacade aiCodeGeneratorFacade;

    @Test
    void generateAndSaveCode() {
        File file = aiCodeGeneratorFacade.generateAndSaveCode("生成一个个人博客网站，代码不超过50行", CodeGenTypeEnum.MULTI_FILE);
        Assertions.assertNotNull(file);
    }
}

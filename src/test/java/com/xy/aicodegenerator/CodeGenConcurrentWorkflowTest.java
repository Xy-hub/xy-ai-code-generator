package com.xy.aicodegenerator;

import com.xy.aicodegenerator.langgraph.CodeGenConcurrentWorkflow;
import com.xy.aicodegenerator.langgraph.state.WorkflowContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CodeGenConcurrentWorkflowTest {

    @Test
    void testConcurrentWorkflow() {
        WorkflowContext result = new CodeGenConcurrentWorkflow().executeWorkflow("创建一个技术博客网站，代码不超过50行");
        Assertions.assertNotNull(result);
        System.out.println("生成类型: " + result.getGenerationType());
        System.out.println("生成的代码目录: " + result.getGeneratedCodeDir());
        System.out.println("构建结果目录: " + result.getBuildResultDir());
        System.out.println("收集的图片数量: " + (result.getImageList() != null ? result.getImageList().size() : 0));
    }

    @Test
    void testEcommerceWorkflow() {
        WorkflowContext result = new CodeGenConcurrentWorkflow().executeWorkflow("创建一个电子商务网站，需要商品展示、购物车和支付功能");
        Assertions.assertNotNull(result);
        System.out.println("生成类型: " + result.getGenerationType());
        System.out.println("生成的代码目录: " + result.getGeneratedCodeDir());
        System.out.println("收集的图片数量: " + (result.getImageList() != null ? result.getImageList().size() : 0));
    }
}

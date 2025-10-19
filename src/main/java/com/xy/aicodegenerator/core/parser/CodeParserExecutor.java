package com.xy.aicodegenerator.core.parser;

import com.xy.aicodegenerator.exception.BusinessException;
import com.xy.aicodegenerator.exception.ErrorCode;
import com.xy.aicodegenerator.model.enums.CodeGenTypeEnum;

import static com.xy.aicodegenerator.model.enums.CodeGenTypeEnum.MULTI_FILE;

/**
 * 代码解析执行器
 * 根据代码生成类型执行相应的解析逻辑
 *
 * @author xy
 */
public class CodeParserExecutor {

    private static final HtmlCodeParser htmlCodeParser = new HtmlCodeParser();

    private static final MultiFileCodeParser multiFileCodeParser = new MultiFileCodeParser();

    /**
     * 执行代码解析
     *
     * @param codeContent 代码内容
     * @param codeGenType 代码生成类型
     * @return 解析结果（HtmlCodeResult 或 MultiFileCodeResult）
     */
    public static Object executeParser(String codeContent, CodeGenTypeEnum codeGenType) {
//        return codeParser.parseCode(codeContent);
        return switch (codeGenType) {
            case HTML -> htmlCodeParser.parseCode(codeContent);
            case MULTI_FILE -> multiFileCodeParser.parseCode(codeContent);
            default -> throw new BusinessException(ErrorCode.SYSTEM_ERROR, "不支持的代码生成类型: " + codeGenType);
        };
    }
}

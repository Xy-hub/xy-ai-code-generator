package com.xy.aicodegenerator.core.saver;

import com.xy.aicodegenerator.ai.model.HtmlCodeResult;
import com.xy.aicodegenerator.ai.model.MultiFileCodeResult;
import com.xy.aicodegenerator.exception.BusinessException;
import com.xy.aicodegenerator.exception.ErrorCode;
import com.xy.aicodegenerator.model.enums.CodeGenTypeEnum;

import java.io.File;

/**
 * 代码文件保存执行器
 * 根据代码生成类型执行相应的保存逻辑
 *
 * @author yupi
 */
public class CodeFileSaverExecutor {

    private static final HtmlCodeFileSaverTemplate htmlCodeFileSaver = new HtmlCodeFileSaverTemplate();

    private static final MultiFileCodeFileSaverTemplate multiFileCodeFileSaver = new MultiFileCodeFileSaverTemplate();

    private static final VueProjectCodeFileSaverTemplate vueProjectCodeFileSaverTemplate = new VueProjectCodeFileSaverTemplate();

    /**
     * 执行代码保存（使用 appId）
     *
     * @param codeResult  代码结果对象
     * @param codeGenType 代码生成类型
     * @param appId       应用 ID
     * @return 保存的目录
     */
    public static File executeSaver(Object codeResult, CodeGenTypeEnum codeGenType, Long appId) {
        return switch (codeGenType) {
            case HTML -> htmlCodeFileSaver.saveCode((HtmlCodeResult) codeResult, appId);
            case MULTI_FILE -> multiFileCodeFileSaver.saveCode((MultiFileCodeResult) codeResult, appId);
            case VUE_PROJECT -> vueProjectCodeFileSaverTemplate.saveCode(codeResult, appId);
            default -> throw new BusinessException(ErrorCode.SYSTEM_ERROR, "不支持的代码生成类型: " + codeGenType);
        };
    }

}

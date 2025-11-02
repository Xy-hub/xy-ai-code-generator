package com.xy.aicodegenerator.core.saver;

import com.xy.aicodegenerator.ai.model.MultiFileCodeResult;
import com.xy.aicodegenerator.constant.AppConstant;
import com.xy.aicodegenerator.core.builder.VueProjectBuilder;
import com.xy.aicodegenerator.model.enums.CodeGenTypeEnum;

public class VueProjectCodeFileSaverTemplate extends CodeFileSaverTemplate<Object>{

    @Override
    protected CodeGenTypeEnum getCodeType() {
        return CodeGenTypeEnum.VUE_PROJECT;
    }

    @Override
    protected void saveFiles(Object result, String baseDirPath) {
        VueProjectBuilder.buildProjectAsync(baseDirPath);
    }
}

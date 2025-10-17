package com.xy.aicodegenerator.model.dto.user;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserLoginRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 3191241716373120793L;

    /**
     * 账号
     */
    @NotBlank
    @Size(min = 4,message = "账号错误")
    private String userAccount;

    /**
     * 密码
     */
    @NotBlank
    @Size(min = 8, message = "密码错误")
    private String userPassword;
}

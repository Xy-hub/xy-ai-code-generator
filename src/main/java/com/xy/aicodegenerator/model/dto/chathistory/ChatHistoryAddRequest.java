package com.xy.aicodegenerator.model.dto.chathistory;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 创建对话历史请求
 */
@Data
public class ChatHistoryAddRequest implements Serializable {

    /**
     * 消息
     */
    private String message;

    /**
     * 消息类型(user/ai/error)
     */
    private String messageType;

    /**
     * 应用id
     */
    private Long appId;

    @Serial
    private static final long serialVersionUID = 1L;
}
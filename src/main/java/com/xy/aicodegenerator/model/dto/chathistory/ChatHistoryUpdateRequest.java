package com.xy.aicodegenerator.model.dto.chathistory;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 更新对话历史请求
 */
@Data
public class ChatHistoryUpdateRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 消息
     */
    private String message;

    /**
     * 消息类型(user/ai/error)
     */
    private String messageType;

    @Serial
    private static final long serialVersionUID = 1L;
}
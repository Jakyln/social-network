package com.mesiproject.socialnetwork.model;

import java.io.Serializable;
import java.util.Objects;

public class ChatGroupUserId implements Serializable {
    private Long userId;
    private Long chatGroupId;

    public ChatGroupUserId(Long userId, Long chatGroupId) {
        this.userId = userId;
        this.chatGroupId = chatGroupId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getChatGroupId() {
        return chatGroupId;
    }

    public void setChatGroupId(Long chatGroupId) {
        this.chatGroupId = chatGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatGroupUserId)) return false;
        ChatGroupUserId that = (ChatGroupUserId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(chatGroupId, that.chatGroupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, chatGroupId);
    }
}

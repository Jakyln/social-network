package com.mesiproject.socialnetwork.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(ChatGroupUserId.class)
public class ChatGroupUser {
    @Id
    Long userId;

    @Id
    Long chatGroupId;

    public ChatGroupUser(Long userId, Long chatGroupId) {
        this.userId = userId;
        this.chatGroupId = chatGroupId;
    }

    public ChatGroupUser() {
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
        if (o == null || getClass() != o.getClass()) return false;
        ChatGroupUser that = (ChatGroupUser) o;
        return Objects.equals(userId, that.userId) && Objects.equals(chatGroupId, that.chatGroupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, chatGroupId);
    }

    @Override
    public String toString() {
        return "ChatGroupUserKey{" +
                "userId=" + userId +
                ", chatGroupId=" + chatGroupId +
                '}';
    }
}


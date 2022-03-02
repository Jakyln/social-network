package com.mesiproject.socialnetwork.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

//@Embeddable
public class ChatGroupUserKey implements Serializable {
    /*@Column(name = "UserId")
    Long userId;

    @Column(name = "ChatGroupId")
    Long chatGroupId;

    public ChatGroupUserKey(Long userId, Long chatGroupId) {
        this.userId = userId;
        this.chatGroupId = chatGroupId;
    }

    public ChatGroupUserKey() {
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
        ChatGroupUserKey that = (ChatGroupUserKey) o;
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
    }*/
}


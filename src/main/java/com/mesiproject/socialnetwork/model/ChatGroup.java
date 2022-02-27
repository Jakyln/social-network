package com.mesiproject.socialnetwork.model;

import java.util.List;
import java.util.Objects;

public class ChatGroup {
    private Long id;
    private List<User> users; //2 ou plus
    private List<Message> messages;

    public ChatGroup(Long id, List<User> users, List<Message> messages) {
        this.id = id;
        this.users = users;
        this.messages = messages;
    }

    public ChatGroup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatGroup chatGroup = (ChatGroup) o;
        return Objects.equals(id, chatGroup.id) && Objects.equals(users, chatGroup.users) && Objects.equals(messages, chatGroup.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, users, messages);
    }

    @Override
    public String toString() {
        return "ChatGroup{" +
                "id=" + id +
                ", users=" + users +
                ", messages=" + messages +
                '}';
    }
}

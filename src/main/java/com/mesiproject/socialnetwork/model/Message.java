package com.mesiproject.socialnetwork.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private LocalDateTime messageDate;
    @ManyToOne
    private User sender; // mettre plus tard une list de User destinataires ?
    @ManyToOne
    private ChatGroup chatGroup;

    public Message(Long id, String text, Date messageDate, User sender, ChatGroup chatGroup) {
        this.id = id;
        this.text = text;
        this.messageDate = LocalDateTime.now();
        this.sender = sender;
        this.chatGroup = chatGroup;
    }

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public ChatGroup getChatGroup() {
        return chatGroup;
    }

    public void setChatGroup(ChatGroup chatGroup) {
        this.chatGroup = chatGroup;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) && Objects.equals(text, message.text) && Objects.equals(messageDate, message.messageDate) && Objects.equals(sender, message.sender) && Objects.equals(chatGroup, message.chatGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, messageDate, sender, chatGroup);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", messageDate=" + messageDate +
                ", sender=" + sender +
                ", chatGroup=" + chatGroup +
                '}';
    }
}

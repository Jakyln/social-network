package com.mesiproject.socialnetwork.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Entity
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    private List<User> users ;
    @ManyToOne
    private User userSender ;
    @ManyToOne
    private User userReceiver ;
    private String name;
//    HashMap<User, List<User>> friendsByUserMap = new HashMap<User, List<User> >();


    public Friends(Long id, User userSender, User userReceiver ) {
        this.id = id;
        this.userSender = userSender;
        this.userReceiver = userReceiver;
        this.name = null;
    }

    public Friends(Long id, User userSender, User userReceiver, String name) {
        this.id = id;
        this.userSender = userSender;
        this.userReceiver = userReceiver;
        this.name = name;
    }


    public User getUserSender() {
        return userSender;
    }

    public void setUserSender(User userSender) {
        this.userSender = userSender;
    }

    public User getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(User userReceiver) {
        this.userReceiver = userReceiver;
    }

    public Friends() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friends friends = (Friends) o;
        return Objects.equals(id, friends.id) && Objects.equals(userSender, friends.userSender) && Objects.equals(userReceiver, friends.userReceiver) && Objects.equals(name, friends.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userSender, userReceiver, name);
    }

    @Override
    public String toString() {
        return "Friends{" +
                "id=" + id +
                ", userSender=" + userSender +
                ", userReceiver=" + userReceiver +
                ", name='" + name + '\'' +
                '}';
    }
}

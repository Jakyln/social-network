package com.mesiproject.socialnetwork.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    private List<User> users ;
    @ManyToOne
    @JoinColumn( name = "userMain" )
    private User userMain;
    @ManyToOne
    private User userFriend;
    private String name;
//    HashMap<User, List<User>> friendsByUserMap = new HashMap<User, List<User> >();


    public Friends(Long id, User userMain, User userFriend) {
        this.id = id;
        this.userMain = userMain;
        this.userFriend = userFriend;
        this.name = null;
    }

    public Friends(Long id, User userMain, User userFriend, String name) {
        this.id = id;
        this.userMain = userMain;
        this.userFriend = userFriend;
        this.name = name;
    }

    public Friends() {
    }

    public User getUserMain() {
        return userMain;
    }

    public void setUserMain(User userMain) {
        this.userMain = userMain;
    }

    public User getUserFriend() {
        return userFriend;
    }

    public void setUserFriend(User userFriend) {
        this.userFriend = userFriend;
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
        return Objects.equals(id, friends.id) && Objects.equals(userMain, friends.userMain) && Objects.equals(userFriend, friends.userFriend) && Objects.equals(name, friends.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userMain, userFriend, name);
    }

    @Override
    public String toString() {
        return "Friends{" +
                "id=" + id +
                ", userMain=" + userMain +
                ", userFriend=" + userFriend +
                ", name='" + name + '\'' +
                '}';
    }
}

package com.mesiproject.socialnetwork.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(FriendsId.class)
public class Friends {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    private List<User> users ;*/
    @Id
    @ManyToOne
    @JoinColumn( name = "UserMainId" )
    private User userMainId;
    @Id
    @ManyToOne
    private User userFriendId;
    private String name;
//    HashMap<User, List<User>> friendsByUserMap = new HashMap<User, List<User> >();

    public Friends(/*Long id,*/ User userSender, User userReceiver, String name) {
        //this.id = id;
        this.userMainId = userSender;
        this.userFriendId = userReceiver;
        this.name = name;
    }


    public User getUserSender() {
        return userMainId;
    }

    public void setUserSender(User userSender) {
        this.userMainId = userSender;
    }

    public User getUserFriendId() {
        return userFriendId;
    }

    public void setUserFriendId(User userFriendId) {
        this.userFriendId = userFriendId;
    }

    public Friends() {
    }

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friends friends = (Friends) o;
        return Objects.equals(id, friends.id) &&Objects.equals(userMainId, friends.userMainId) && Objects.equals(userFriendId, friends.userFriendId) && Objects.equals(name, friends.name);
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(/*id,*/ userMainId, userFriendId, name);
    }

    @Override
    public String toString() {
        return "Friends{" +
                /*"id=" + id +*/
                ", userSender=" + userMainId +
                ", userReceiver=" + userFriendId +
                ", name='" + name + '\'' +
                '}';
    }
}

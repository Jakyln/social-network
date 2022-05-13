package com.mesiproject.socialnetwork.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(FriendsId.class)
public class Friends {
    @Id
    private Long userMainId;
    @Id
    private Long userFriendId;

    private String name;
//    HashMap<User, List<User>> friendsByUserMap = new HashMap<User, List<User> >();


    public Friends(Long userMainId, Long userFriendId) {
        this.userMainId = userMainId;
        this.userFriendId = userFriendId;
        this.name = null;
    }

    public Friends(Long userMainId, Long userFriendId, String name) {
        this.userMainId = userMainId;
        this.userFriendId = userFriendId;
        this.name = name;
    }

    public Friends() {
    }

    public Long getUserMainId() {
        return userMainId;
    }

    public void setUserMainId(Long userMainId) {
        this.userMainId = userMainId;
    }

    public Long getUserFriendId() {
        return userFriendId;
    }

    public void setUserFriendId(Long userFriendId) {
        this.userFriendId = userFriendId;
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
        return Objects.equals(userMainId, friends.userMainId) && Objects.equals(userFriendId, friends.userFriendId) && Objects.equals(name, friends.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userMainId, userFriendId, name);
    }

    @Override
    public String toString() {
        return "Friends{" +
                ", userMain=" + userMainId +
                ", userFriend=" + userFriendId +
                ", name='" + name + '\'' +
                '}';
    }
}

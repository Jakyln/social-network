package com.mesiproject.socialnetwork.model;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Friends {
    private Long id;
//    private List<User> users ;
    private String name;
    HashMap<User, List<User>> friendsByUserMap = new HashMap<User, List<User> >();


    public Friends(Long id, String name, HashMap<User, List<User>> friendsByUserMap) {
        this.id = id;
        this.name = name;
        this.friendsByUserMap = friendsByUserMap;
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

    public HashMap<User, List<User>> getFriendsByUserMap() {
        return friendsByUserMap;
    }

    public void setFriendsByUserMap(HashMap<User, List<User>> friendsByUserMap) {
        this.friendsByUserMap = friendsByUserMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friends friends = (Friends) o;
        return Objects.equals(id, friends.id) && Objects.equals(name, friends.name) && Objects.equals(friendsByUserMap, friends.friendsByUserMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, friendsByUserMap);
    }

    @Override
    public String toString() {
        return "Friends{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", friendsByUserMap=" + friendsByUserMap +
                '}';
    }
}

package com.mesiproject.socialnetwork.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*private Long user_main;
    private Long user_friend;*/

//    @ManyToMany(mappedBy = "friends")
    @ManyToOne
    private User users;



    public Friends() {
    }

    public Friends(Long id, User users) {
        this.id = id;
        this.users = users;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friends friends = (Friends) o;
        return Objects.equals(id, friends.id) && Objects.equals(users, friends.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, users);
    }
}

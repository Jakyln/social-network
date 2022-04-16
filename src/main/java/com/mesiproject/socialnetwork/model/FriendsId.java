package com.mesiproject.socialnetwork.model;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

//@Embeddable
public class FriendsId implements Serializable {
    //@JoinColumn( name = "userMain" )
    /*private User userMain;
    //@ManyToOne
    private User userFriend;


    public FriendsId(User userMain, User userFriend) {
        this.userMain = userMain;
        this.userFriend = userFriend;
    }

    public FriendsId() {
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
    }*/


}


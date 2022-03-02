package com.mesiproject.socialnetwork.model;

import java.io.Serializable;
import java.util.Objects;

public class FriendsId implements Serializable {
    private User userMainId;
    private User userFriendId;

    public FriendsId(User userMainId, User userFriendId) {
        this.userMainId = userMainId;
        this.userFriendId = userFriendId;
    }

    public User getUserMainId() {
        return userMainId;
    }

    public void setUserMainId(User userMainId) {
        this.userMainId = userMainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FriendsId)) return false;
        FriendsId friendsId = (FriendsId) o;
        return Objects.equals(userMainId, friendsId.userMainId) && Objects.equals(userFriendId, friendsId.userFriendId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userMainId, userFriendId);
    }
}

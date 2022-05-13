package com.mesiproject.socialnetwork.model;

import java.io.Serializable;
import java.util.Objects;

public class FriendsId implements Serializable {
    private Long userMainId;
    private Long userFriendId;

    public FriendsId(Long userMainId, Long userFriendId) {
        this.userMainId = userMainId;
        this.userFriendId = userFriendId;
    }

    public Long getUserMainId() {
        return userMainId;
    }

    public void setUserMain(Long userMainId) {
        this.userMainId = userMainId;
    }

    public Long getUserFriendId() {
        return userFriendId;
    }

    public void setUserFriend(Long userFriendId) {
        this.userFriendId = userFriendId;
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

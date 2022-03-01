package com.mesiproject.socialnetwork.repository;

import com.mesiproject.socialnetwork.model.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendsRepository extends JpaRepository<Friends, Long> {
}

package com.mesiproject.socialnetwork.repository;

import com.mesiproject.socialnetwork.model.ChatGroup;
import com.mesiproject.socialnetwork.model.ChatGroupUser;
import com.mesiproject.socialnetwork.model.ChatGroupUserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ChatGroupUserRepository extends JpaRepository<ChatGroupUser, ChatGroupUserId> {
    List<ChatGroupUser> findAllByUserId(Long userId);
}

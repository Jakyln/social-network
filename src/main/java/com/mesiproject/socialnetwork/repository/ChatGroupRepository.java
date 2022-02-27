package com.mesiproject.socialnetwork.repository;

import com.mesiproject.socialnetwork.model.ChatGroup;
import com.mesiproject.socialnetwork.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatGroupRepository  extends JpaRepository<ChatGroup, Long> {

}

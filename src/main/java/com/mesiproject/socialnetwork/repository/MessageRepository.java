package com.mesiproject.socialnetwork.repository;

import com.mesiproject.socialnetwork.model.ChatGroup;
import com.mesiproject.socialnetwork.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}

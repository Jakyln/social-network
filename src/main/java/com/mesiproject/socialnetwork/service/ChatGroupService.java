package com.mesiproject.socialnetwork.service;

import com.mesiproject.socialnetwork.model.ChatGroup;
import com.mesiproject.socialnetwork.model.User;
import com.mesiproject.socialnetwork.repository.ChatGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ChatGroupService {

    @Autowired
    private ChatGroupRepository chatGroupRepository;


    public ChatGroup findById(Long id) {
        Optional<ChatGroup> chatGroup = this.chatGroupRepository.findById(id);
        if(!chatGroup.isPresent()){
            throw new EntityNotFoundException("Impossible de trouver la discussion d'identifiant " + id);
        }
        return chatGroup.get();
    }

    public ChatGroup createChatGroup(ChatGroup chatGroup) {
        return chatGroupRepository.save(chatGroup);
    }


    public ChatGroup updateChatGroup(ChatGroup chatGroup) {
        return chatGroupRepository.save(chatGroup);
    }

    public void deleteChatGroup(Long id) {
        chatGroupRepository.deleteById(id);
    }


}

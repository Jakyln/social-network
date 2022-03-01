package com.mesiproject.socialnetwork.service;

import com.mesiproject.socialnetwork.model.ChatGroup;
import com.mesiproject.socialnetwork.model.Message;
import com.mesiproject.socialnetwork.repository.ChatGroupRepository;
import com.mesiproject.socialnetwork.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;


    public Message findById(Long id) {
        Optional<Message> message = this.messageRepository.findById(id);
        if(!message.isPresent()){
            throw new EntityNotFoundException("Impossible de trouver le message d'identifiant " + id);
        }
        return message.get();
    }

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    public Message updateMessage(Message message) {
        return messageRepository.save(message);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}

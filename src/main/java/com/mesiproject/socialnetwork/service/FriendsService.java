package com.mesiproject.socialnetwork.service;

import com.mesiproject.socialnetwork.model.ChatGroup;
import com.mesiproject.socialnetwork.model.Friends;
import com.mesiproject.socialnetwork.model.Message;
import com.mesiproject.socialnetwork.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class FriendsService {
    @Autowired
    FriendsRepository friendsRepository;

    public Friends findById(Long id) {
        Optional<Friends> friend = this.friendsRepository.findById(id);
        if(!friend.isPresent()){
            throw new EntityNotFoundException("Impossible de trouver l'ami d'identifiant " + id);
        }
        return friend.get();
    }

    public Friends addFriend(Friends friend) {
        return friendsRepository.save(friend);
    }

    public Friends updateFriend(Friends friend) {
        return friendsRepository.save(friend);
    }

    public void deleteFriend(Long id) {
        friendsRepository.deleteById(id);
    }

}

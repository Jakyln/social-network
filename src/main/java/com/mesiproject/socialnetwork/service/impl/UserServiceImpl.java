package com.mesiproject.socialnetwork.service.impl;

import com.mesiproject.socialnetwork.model.Friends;
import com.mesiproject.socialnetwork.model.User;
import com.mesiproject.socialnetwork.repository.UserRepository;
import com.mesiproject.socialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsernameOrEmail(String usernameOrEmail){
        User user;
        try{
            user = userRepository.findByUsernameOrEmail(usernameOrEmail);
        }
        catch (Exception e){
            throw e;
        }
        return user;
    }
    @Transactional
    public User findById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        if(!user.isPresent()){
            throw new EntityNotFoundException("Impossible de trouver l'utilisateur d'identifiant " + id);
        }
        Set<Friends> userFriends = user.get().getFriends();
        return user.get();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) { //fonction pour admin ou quand user veut supprimer son compte
        userRepository.deleteById(id);
    }


}

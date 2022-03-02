package com.mesiproject.socialnetwork.controller;

import com.mesiproject.socialnetwork.dto.UserDto;
import com.mesiproject.socialnetwork.model.ChatGroup;
import com.mesiproject.socialnetwork.model.User;
import com.mesiproject.socialnetwork.service.ChatGroupService;
import com.mesiproject.socialnetwork.service.UserService;
import com.mesiproject.socialnetwork.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @RequestMapping(
            method = RequestMethod.GET,
            value ="/{id}"
    )
    public ModelAndView detailUser(@PathVariable Long id){
        ModelAndView model = new ModelAndView("userDetails");
        if(id != null){
            model.addObject("user",userService.findById(id));
            return model;
        }
        throw new EntityNotFoundException("L'utilisateur d'id " + id + " n'existe pas !");
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value ="/{id}/allFriends"
    )
    public ModelAndView allFriends(@PathVariable Long id){
        ModelAndView model = new ModelAndView("friendList");
        if(id != null){
            model.addObject("friends",userService.findById(id).getFriends());
            return model;
        }
        throw new EntityNotFoundException("L'utilisateur d'id " + id + " n'existe pas !");
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/new"
    )
    public ModelAndView newUser(){ //  Pour Login création de compte
        ModelAndView model = new ModelAndView("userDetails");
        User user  = new User();
        model.addObject("user", user);
        return model;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public RedirectView createUser(User user){

        /*if(chatGroupService.checkExistsByName(chatGroup.getName())){
            throw new EntityExistsException("Il existe déjà une discussion identique en base");
        }*/

        if(user.getUsername().trim().length()>0){ //vérifie si le user n'a pas mis que des espaces
            try {
                if(user.getId() == null){
                    //Création
                    user = userService.createUser(user);
                }
                else {
                    //Modification
                    user = userService.updateUser(user);
                }
            }
            catch(Exception e){
                throw new IllegalArgumentException("Problème lors de la sauvegarde de la discussion");
            }
        }
        else{
            throw new IllegalArgumentException("Veuillez remplir le champ du nom de l'artiste");
        }
        return new RedirectView("/user/" + user.getId());
    }
}

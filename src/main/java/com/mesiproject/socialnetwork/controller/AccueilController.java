package com.mesiproject.socialnetwork.controller;

import com.mesiproject.socialnetwork.model.ChatGroup;
import com.mesiproject.socialnetwork.model.Friends;
import com.mesiproject.socialnetwork.service.ChatGroupService;
import com.mesiproject.socialnetwork.service.FriendsService;
import com.mesiproject.socialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@RestController
public class AccueilController {

    @Autowired
    private UserService userService;

    @Autowired
    private ChatGroupService chatGroupService;

    @Autowired
    private FriendsService friendsService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/" //URL
    )
    public String accueil(){
        return "messagerie";
    }

    /*public ModelAndView accueil(){
        ModelAndView model = new ModelAndView("accueil");
        model.addObject("user",userService.findById(id));
        return model;
    }*/



}

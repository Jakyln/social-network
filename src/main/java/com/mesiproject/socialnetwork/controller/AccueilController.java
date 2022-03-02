package com.mesiproject.socialnetwork.controller;

import com.mesiproject.socialnetwork.model.ChatGroup;
import com.mesiproject.socialnetwork.model.Friends;
import com.mesiproject.socialnetwork.service.ChatGroupService;
import com.mesiproject.socialnetwork.service.FriendsService;
import com.mesiproject.socialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
public class AccueilController {

    @Autowired
    private UserService userService;

    @Autowired
    private ChatGroupService chatGroupService;

    @Autowired
    private FriendsService friendsService;

    //todo url à modifier avec système de login
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/acceuil/{id}" //URL
    )
    /*public String accueil(){
        return "accueil";
    }*/

    public ModelAndView accueil(@PathVariable Long id){
        ModelAndView model = new ModelAndView("accueil");
        model.addObject("user",userService.findById(id));
        return model;
    }



}

package com.mesiproject.socialnetwork.controller;

import com.mesiproject.socialnetwork.model.ChatGroup;
import com.mesiproject.socialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/")
public class AccueilController {

    @Autowired
    private UserService userService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "" //URL
    )
    public String accueil(){
        return "accueil";
    }

    public ModelAndView accueil(@PathVariable Long id){
        ModelAndView model = new ModelAndView("accueil");
        model.addObject("user",userService.findById(id));
        return model;
    }
}

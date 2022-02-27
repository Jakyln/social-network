package com.mesiproject.socialnetwork.controller;

import com.mesiproject.socialnetwork.model.ChatGroup;
import com.mesiproject.socialnetwork.service.ChatGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatGroupService chatGroupService;




    @RequestMapping(
            method = RequestMethod.GET,
            value ="/{id}"
    )
    public ModelAndView detailChat(@PathVariable Long id){
        ModelAndView model = new ModelAndView("detailArtist");
        if(id != null){
            model.addObject("artist",chatGroupService.findById(id));
            return model;
        }
        throw new EntityNotFoundException("L'artiste d'identifiant " + id + " n'existe pas !");
    }

}

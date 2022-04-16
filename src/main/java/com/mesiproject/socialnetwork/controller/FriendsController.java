package com.mesiproject.socialnetwork.controller;

import com.mesiproject.socialnetwork.model.Friends;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class FriendsController {




    /*@RequestMapping(
            method = RequestMethod.GET,
            value = "friends/new"
    )
    public ModelAndView newFriend(){ // quand on va dans artists/new , ca nous redirige vers un détail d'artise vide. Ensuite le btn enregistrer utilise la fonction createArtist  (POST)
        ModelAndView model = new ModelAndView("friendList");
        Friends friend  = new Friends();
        model.addObject("Friend", friend);
        return model;
    }*/

    /*@RequestMapping(
            method = RequestMethod.GET,
            value = "friends/new"
    )
    public ModelAndView newFriend(){ // quand on va dans artists/new , ca nous redirige vers un détail d'artise vide. Ensuite le btn enregistrer utilise la fonction createArtist  (POST)
        ModelAndView model = new ModelAndView("newFriend");
        Friends friend  = new Friends();
        model.addObject("Friend", friend);
        return model;
    }*/
}

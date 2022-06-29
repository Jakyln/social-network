package com.mesiproject.socialnetwork.controller;

import com.mesiproject.socialnetwork.model.ChatGroup;
import com.mesiproject.socialnetwork.model.Message;
import com.mesiproject.socialnetwork.security.CustomUserDetails;
import com.mesiproject.socialnetwork.service.ChatGroupService;
import com.mesiproject.socialnetwork.service.MessageService;
import com.mesiproject.socialnetwork.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatGroupService chatGroupService;

    @Autowired
    private MessageService messageService;


    //A enlever, il ne faut pas abuser de l'injection de services dans d'autre services
    @Autowired
    private UserServiceImpl userService;


    @RequestMapping(
            method = RequestMethod.GET,
            value ="/{id}"
    )
    public ModelAndView detailChat(@PathVariable Long id){
        ModelAndView model = new ModelAndView("messagerie");
        if(id != null){
            model.addObject("chatGroup",chatGroupService.findById(id));
            return model;
        }
        throw new EntityNotFoundException("La discussion d'id " + id + " n'existe pas !");
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value =""
    )
    public ModelAndView getAllChats(){
        ModelAndView model = new ModelAndView("chatsList");
        CustomUserDetails userDetails =
                (CustomUserDetails) SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal();


        //Méthode 1 pour récupérer les chat groups d'un user avec l'id de celui-ci
        //List<ChatGroup> allChats = chatGroupService.getChatGroupsOfUser(userDetails.getId());

        //Méthode 2 : Le User chargé de Spring security n'a pas toutes les sous List d' objets (chatgroups, friends), il faut donc faire une requête de BDD pour récupérer le User entier
        List<ChatGroup> allChats = userService.findById(userDetails.getId()).getChatGroups();
        model.addObject("allChats",allChats);
        return model;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/new"
    )
    public ModelAndView newChat(){ // quand on va dans artists/new , ca nous redirige vers un détail d'artise vide. Ensuite le btn enregistrer utilise la fonction createArtist  (POST)
        ModelAndView model = new ModelAndView("newChat");
        ChatGroup chatGroup  = new ChatGroup();
        model.addObject("chatGroup", chatGroup);
        return model;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public RedirectView createChatGroup(ChatGroup chatGroup){

        /*if(chatGroupService.checkExistsByName(chatGroup.getName())){
            throw new EntityExistsException("Il existe déjà une discussion identique en base");
        }*/

        if(chatGroup.getName().trim().length()>0){ //vérifie si le user n'a pas mis que des espaces
            try {
                if(chatGroup.getId() == null){
                    //Création
                    chatGroup = chatGroupService.createChatGroup(chatGroup);
                }
                else {
                    //Modification
                    chatGroup = chatGroupService.updateChatGroup(chatGroup);
                }
            }
            catch(Exception e){
                throw new IllegalArgumentException("Problème lors de la sauvegarde de la discussion");
            }
        }
        else{
            throw new IllegalArgumentException("Veuillez remplir le champ du nom de l'artiste");
        }
        return new RedirectView("/chats/" + chatGroup.getId());
    }


   @RequestMapping(
            value = "/{groupChatId}/displayAllMessagesOfGroup",
            method = RequestMethod.GET
    )
    public ModelAndView findAllMessagesOfGroupChat(@PathVariable Long groupChatId){

       ModelAndView model = new ModelAndView("chatGroup");
       model.addObject("allMessages",messageService.findAllMessagesOfGroupChat(groupChatId));
       return model;
    }

}

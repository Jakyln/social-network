package com.mesiproject.socialnetwork.model;

import java.util.Date;

public class Message {
    private Long id;
    private String text;
    private Date messageDate;
    private User sender; // mettre plus tard une list de User destinataires ?
    private ChatGroup chatGroup;


}

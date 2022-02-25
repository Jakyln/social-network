package com.mesiproject.socialnetwork.dto;

import java.util.Date;

public class UserDto {
    private Long id;
    private String username; //username et password utilisé pour se connecter
    private String firstName;
    private String lastName;
    private String status; // online ou offline
    private String bio; //100 caractères de descriptions de profil
    private String relationship; //single, in couple, prefer not to say
}

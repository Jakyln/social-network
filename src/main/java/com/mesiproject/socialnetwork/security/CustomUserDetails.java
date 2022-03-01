package com.mesiproject.socialnetwork.security;

import com.mesiproject.socialnetwork.model.ChatGroup;
import com.mesiproject.socialnetwork.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.*;

public class CustomUserDetails implements UserDetails {
    String ROLE_PREFIX = "ROLE_";

    private Long id;
    private String username; //username et password utilisé pour se connecter
    private String password;
    private String mail; // utilisé si oublié mdp
    private String firstName;
    private String lastName;
    private String statusName; // online ou offline
    private Date birthDate;
    private String address;
    private String bio; //100 caractères de descriptions de profil
    private String relationship; //single, in couple, prefer not to say
    private String zipCode;
    private LocalDateTime loginDate;
    private List<ChatGroup> chatGroups; //2 ou plus
    private Role role;


    public CustomUserDetails(String username, String password, String mail, String firstName, String lastName, String status, Date birthDate, String address, String bio, String relationship, List<ChatGroup> chatGroups, String zipCode, Role role) {
        super();
        //this.id = id;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.statusName = status;
        this.birthDate = birthDate;
        this.address = address;
        this.bio = bio;
        this.relationship = relationship;
        this.chatGroups = chatGroups;
        this.zipCode = zipCode;
        this.loginDate = LocalDateTime.now();
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));

        return list;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStatusName() {
        return statusName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getBio() {
        return bio;
    }

    public String getRelationship() {
        return relationship;
    }

    public String getZipCode() {
        return zipCode;
    }

    public LocalDateTime getLoginDate() {
        return loginDate;
    }

    public List<ChatGroup> getChatGroups() {
        return chatGroups;
    }

    public Role getRole() {
        return role;
    }
}

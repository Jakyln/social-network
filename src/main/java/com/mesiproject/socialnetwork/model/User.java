package com.mesiproject.socialnetwork.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username; //username et password utilisé pour se connecter
    private String password;
    private String mail; // utilisé si oublié mdp
    private String firstName;
    private String lastName;
    private String birthDate;
    private String zipCode;
    private String address;
    private String bio; //100 caractères de descriptions de profil
    private String relationship; //single, in couple, prefer not to say
    private LocalDateTime loginDate;
    private String status; // online ou offline

    @ManyToMany//(fetch = FetchType.EAGER, mappedBy = "chatGroups", cascade = CascadeType.ALL)
    @JoinTable(
            name = "ChatGroupUser",
            joinColumns = @JoinColumn(name = "UserId"),
            inverseJoinColumns = @JoinColumn(name = "ChatGroupId"))
    private Set<ChatGroup> chatGroups; //2 ou plus
    @OneToOne
    private Role role;

    /*@JsonIgnoreProperties("userMainId")
    @OneToMany(mappedBy = "userMainId")
    private List<User> friends = new ArrayList<>();*/

    @ManyToMany
    @JoinTable(name = "Friends",
            joinColumns = @JoinColumn(name = "userMain"),
            inverseJoinColumns = @JoinColumn(name = "userFriend")
    )
    private List<User> friends = new ArrayList<>();;


    public User() {
    }


    public User(Long id, String username, String password, String mail, String firstName, String lastName, String birthDate, String address, String bio, String relationship,String zipCode,String status,Role role,Set<ChatGroup> chatGroups,List<User> friends) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.birthDate = birthDate;
        this.address = address;
        this.bio = bio;
        this.relationship = relationship;
        this.chatGroups = chatGroups;
        this.zipCode = zipCode;
        this.friends = friends;
        this.loginDate = LocalDateTime.now();
        this.role = role;
    }

    public User(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.mail = user.getMail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.status = user.getStatus();
        this.birthDate = user.getBirthDate();
        this.address = user.getAddress();
        this.bio = user.getBio();
        this.relationship = user.getRelationship();
        this.chatGroups = user.getChatGroups();
        this.zipCode = user.getZipCode();
        this.loginDate = user.getLoginDate();
        this.role = user.getRole();
        this.friends = user.getFriends();
    }

    public Set<ChatGroup> getChatGroups() {
        return chatGroups;
    }

    public void setChatGroups(Set<ChatGroup> chatGroups) {
        this.chatGroups = chatGroups;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }


    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Role getRole() {
        return role;
    }
    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }


    public LocalDateTime getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(LocalDateTime loginDate) {
        this.loginDate = loginDate;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    

}

package com.mesiproject.socialnetwork.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToMany
    private List<ChatGroup> chatGroups; //2 ou plus

    @JsonIgnoreProperties("userMainId")
    @OneToMany(mappedBy = "userMainId")
    private List<Friends> friends = new ArrayList<>();


    public User() {
    }

    public User(Long id, String username, String password, String mail, String firstName, String lastName, String status, Date birthDate, String address, String bio, String relationship, List<ChatGroup> chatGroups, String zipCode, List<Friends> friends) {
        this.id = id;
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
        this.friends = friends;
        this.loginDate = LocalDateTime.now();
    }

    public List<ChatGroup> getChatGroups() {
        return chatGroups;
    }

    public void setChatGroups(List<ChatGroup> chatGroups) {
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
        return statusName;
    }

    public void setStatus(String status) {
        this.statusName = status;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
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

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public List<Friends> getFriends() {
        return friends;
    }

    public void setFriends(List<Friends> friends) {
        this.friends = friends;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(mail, user.mail) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(statusName, user.statusName) && Objects.equals(birthDate, user.birthDate) && Objects.equals(address, user.address) && Objects.equals(bio, user.bio) && Objects.equals(relationship, user.relationship) && Objects.equals(zipCode, user.zipCode) && Objects.equals(loginDate, user.loginDate) && Objects.equals(chatGroups, user.chatGroups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, mail, firstName, lastName, statusName, birthDate, address, bio, relationship, zipCode, loginDate, chatGroups);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", statusName='" + statusName + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", bio='" + bio + '\'' +
                ", relationship='" + relationship + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", loginDate=" + loginDate +
                ", chatGroups=" + chatGroups +
                '}';
    }
}

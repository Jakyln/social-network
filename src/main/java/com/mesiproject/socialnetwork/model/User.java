package com.mesiproject.socialnetwork.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User {
    private Long id;
    private String username; //username et password utilisé pour se connecter
    private String password;
    private String mail; // utilisé si oublié mdp
    private String firstName;
    private String lastName;
    private String status; // online ou offline
    private Date birthDate;
    private String birthPlace;
    private String address;
    private String bio; //100 caractères de descriptions de profil
    private String relationship; //single, in couple, prefer not to say

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(mail, user.mail) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(status, user.status) && Objects.equals(birthDate, user.birthDate) && Objects.equals(birthPlace, user.birthPlace) && Objects.equals(address, user.address) && Objects.equals(bio, user.bio) && Objects.equals(relationship, user.relationship);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, mail, firstName, lastName, status, birthDate, birthPlace, address, bio, relationship);
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
                ", status='" + status + '\'' +
                ", birthDate=" + birthDate +
                ", birthPlace='" + birthPlace + '\'' +
                ", address='" + address + '\'' +
                ", bio='" + bio + '\'' +
                ", relationship='" + relationship + '\'' +
                '}';
    }
}

package com.petscare.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "TPC_USER")
@NamedQuery(name = "AppUser.findAll", query = "SELECT t FROM AppUser t")
public class AppUser {

    @Id
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name ="EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "BIRTH_DATE")
    private LocalDate dateBorn;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE")
    private String phone;

    @OneToOne(mappedBy = "appUser")
    private AppStoryService storyServices;

    @OneToMany(mappedBy = "appUser")
    private List<AppServiceCommentary> commentaries;


    public AppUser(){

    }
    
}
package com.petscare.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "Identification")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name ="Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "BirthDate")
    private LocalDate dateBorn;

    @Column(name = "Address")
    private String address;

    @Column(name = "Phone")
    private String phone;

    // @OneToOne(mappedBy = "storyService")
    // private StoryService storyServices;


    public User(){

    }
    
}
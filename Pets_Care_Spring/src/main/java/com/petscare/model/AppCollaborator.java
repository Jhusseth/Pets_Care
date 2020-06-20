package com.petscare.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name =  "TPC_COLLABORATOR")
@NamedQuery(name = "AppCollaborator.findAll", query = "SELECT t FROM AppCollaborator t")
public class AppCollaborator {

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


    @Column(name = "DESCRIPTION")
    private String Description;


    @OneToMany(mappedBy = "appCollaborator")
    private List<AppService> services;


    public AppCollaborator(){

    }


    
}
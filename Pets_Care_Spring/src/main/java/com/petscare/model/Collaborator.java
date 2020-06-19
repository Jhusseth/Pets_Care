package com.petscare.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name =  "COLLABORATOR")
public class Collaborator {

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


    @Column(name = "Description")
    private String Description;


    // @OneToMany(mappedBy = "service")
    // private List<Service> services;


    public Collaborator(){

    }


    
}
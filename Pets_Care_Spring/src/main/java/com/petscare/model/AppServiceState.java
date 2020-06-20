package com.petscare.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "TPC_STATE")
@NamedQuery(name = "AppServiceState.findAll", query = "SELECT t FROM AppServiceState t")
public class AppServiceState {

    @Id
    @SequenceGenerator(name = "SEQ_STATE_GEN",allocationSize = 1 ,sequenceName = "TPS_STATE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_STATE_GEN")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "appServiceState")
    private AppService service;

    private AppServiceState(){

    }
    
    
}
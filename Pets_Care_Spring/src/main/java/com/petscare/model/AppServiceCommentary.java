package com.petscare.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "TPC_COMMENTARY")
@NamedQuery(name = "AppServiceCommentary.findAll", query = "SELECT t FROM AppServiceCommentary t")
public class AppServiceCommentary {

    @Id
    @SequenceGenerator(name = "SEQ_COMMENTARY_GEN", allocationSize = 1,sequenceName = "TPC_COMMENTARY_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_COMMENTARY_GEN")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TPC_USER_ID")
    private AppUser appUser;

    @Column(name = "COMMENTARY")
    private String commentary;

    @ManyToOne
    @JoinColumn(name = "TPC_SERVICE_ID")
    private AppService appService;


    public AppServiceCommentary(){
        
    }
    
}
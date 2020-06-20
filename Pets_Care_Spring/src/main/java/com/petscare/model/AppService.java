package com.petscare.model;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "TPC_SERVICE")
@NamedQuery(name = "AppService.findAll", query = "SELECT t FROM AppService t")
public class AppService {

    @Id
    @SequenceGenerator(name = "SEQ_SERVICE_GEN",allocationSize = 1, sequenceName = "TCP_SERVICE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_SERVICE_GEN")
    private Long id;
    
    @Column(name = "TITLE")
    private String title;
    
    @Column(name = "DESCRIPTION")
    private String Description;

    @ManyToOne
    @JoinColumn(name = "TPC_STATE_ID")
    private AppServiceState appServiceState;

    @ManyToOne
    @JoinColumn(name = "TPC_COLLABORATOR_ID")
    private AppCollaborator appCollaborator;

    @ManyToOne
    @JoinColumn(name = "TPC_STORY_SERVICE_ID")
    private AppStoryService appStoryService;

    @OneToMany(mappedBy = "appService")
    private List<AppServiceCommentary> commentaries;


    public AppService(){
        
    }
    
}
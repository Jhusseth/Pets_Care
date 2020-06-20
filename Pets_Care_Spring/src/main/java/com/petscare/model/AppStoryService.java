package com.petscare.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "TPC_STORY_SERVICES")
@NamedQuery(name = "AppStoryService.findAll", query = "SELECT t FROM AppStoryService t")
public class AppStoryService {

    @Id
    @SequenceGenerator(name = "SEQ_STORY_SERVICE_GENERATOR",allocationSize = 1, sequenceName = "TPC_STORY_SERVICES_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_STORY_SERVICE_GENERATOR")
    private Long id;


    @OneToOne
    @JoinColumn(name ="TPC_USER_ID")
    private AppUser appUser;

    @Column(name = "STORY_DATE")
    private LocalDate date;

    @OneToMany(mappedBy = "appStoryService")
    private List<AppService> services;

    public AppStoryService(){

    }
    
}
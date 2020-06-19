package com.petscare.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "STORY_SERVICES")
public class StoryService {

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "STORY_SERVICES_SEQ",initialValue = 1,allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_GEN")
    private Long id;


    @OneToOne
    private User user;

    @Column(name = "Date")
    private LocalDate date;

    // @OneToMany(mappedBy = "service")
    // private List<Service> services;

    public StoryService(){

    }
    
}
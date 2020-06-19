package com.petscare.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "SERVICE")
public class Service {

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SERVICES_SEQ",initialValue = 1,allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_GEN")
    private Long id;
    
    @Column(name = "Title")
    private String title;
    
    @Column(name = "Description")
    private String Description;

    @ManyToOne
    private State state;

    @ManyToOne
    private Collaborator collaborator;

    @ManyToOne
    private StoryService storyService;


    // @OneToMany(mappedBy = "commentary")
    // private List<Commentary> commentaries;


    public Service (){
        
    }
    
}
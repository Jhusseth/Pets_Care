package com.petscare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "STATE")
public class State {

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "STATE_SEQ",initialValue = 1,allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_GEN")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    // @OneToMany(mappedBy = "service")
    // private Service service;

    private State(){

    }
    
    
}
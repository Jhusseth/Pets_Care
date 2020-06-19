package com.petscare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "COMMENTARY")
public class Commentary {

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SERVICES_SEQ",initialValue = 1,allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_GEN")
    private Long id;

    @ManyToOne
    private User user;

    @Column(name = "Commentary")
    private String commentary;

    @ManyToOne
    private Service service;

    public Commentary(){
        
    }
    
}
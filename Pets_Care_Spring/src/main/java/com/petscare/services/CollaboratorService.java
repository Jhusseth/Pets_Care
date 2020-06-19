package com.petscare.services;

import com.petscare.model.Collaborator;

public interface CollaboratorService {

    public Collaborator save(Collaborator coll);
    public Collaborator update (Collaborator coll);
    public void delete(long id);
    public Collaborator findById(long id);
    public Collaborator findByEmail(String email);
    public Iterable<Collaborator> findAll();
    
}
package com.petscare.dao;

import com.petscare.model.Collaborator;

public interface CollaboratorDao {

    public Collaborator save(Collaborator coll);
    public Collaborator update(Collaborator coll);
    public void delete(Collaborator coll);
    public Collaborator findById(long id);
    public Iterable<Collaborator> findAll();
    public Collaborator findByEmail(String email);
    
}
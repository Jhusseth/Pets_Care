package com.petscare.dao;

import com.petscare.model.AppCollaborator;

public interface CollaboratorDao {

    public AppCollaborator save(AppCollaborator coll);
    public AppCollaborator update(AppCollaborator coll);
    public void delete(AppCollaborator coll);
    public AppCollaborator findById(long id);
    public Iterable<AppCollaborator> findAll();
    public AppCollaborator findByEmail(String email);
    
}
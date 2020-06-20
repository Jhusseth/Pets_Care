package com.petscare.restControllers;

import com.petscare.model.AppCollaborator;

public interface CollaboratorRestController {

    public AppCollaborator save(AppCollaborator coll);
    public AppCollaborator update (AppCollaborator coll);
    public void delete(long id);
    public AppCollaborator findById(long id);
    public AppCollaborator findByEmail(String email);
    public Iterable<AppCollaborator> findAll();
    
}
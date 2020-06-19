package com.petscare.restControllers;

import com.petscare.model.Commentary;

public interface CommentaryRestController {

    public Commentary save(long id,Commentary comment);
    public Commentary update(Commentary comment);
    public void delete(long id);
    public Commentary findById(long id);
    public Iterable<Commentary> findByUser(long id);
    public Iterable<Commentary> findByService(long id);
    public Iterable<Commentary> findAll(); 
    
}
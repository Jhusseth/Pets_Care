package com.petscare.dao;

import com.petscare.model.Commentary;

public interface CommentaryDao {

    public Commentary save (Commentary comment);
    public Commentary update (Commentary comment);
    public void delete (Commentary comment);
    public Commentary findById(long id);
    public Iterable<Commentary> findByUser(long id);
    public Iterable<Commentary> findByService(long id);
    public Iterable<Commentary> findAll();
    
}
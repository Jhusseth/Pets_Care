package com.petscare.dao;

import com.petscare.model.AppCollaborator;
import com.petscare.model.AppService;

public interface ServiceDao {

    public AppService save(AppService appService);
    public AppService update(AppService appService);
    public void delete(AppService appService);
    public Iterable<AppService> findAll();
    public AppService findById(long id);
    public Iterable<AppService> findByCollaborator(AppCollaborator coll);
    
}
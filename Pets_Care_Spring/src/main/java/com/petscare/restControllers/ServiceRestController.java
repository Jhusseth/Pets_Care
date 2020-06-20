package com.petscare.restControllers;
import com.petscare.model.AppService;

public interface ServiceRestController {

    public AppService save(long id, AppService appService);
    public AppService update (AppService appService);
    public void delete(long id);
    public AppService findById(long id);
    public Iterable<AppService> findByCollaborator(long id);
    public Iterable<AppService> findAll();
    
}
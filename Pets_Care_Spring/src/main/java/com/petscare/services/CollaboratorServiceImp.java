package com.petscare.services;

import com.petscare.dao.CollaboratorDao;
import com.petscare.model.AppCollaborator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorServiceImp implements CollaboratorService {

    @Autowired
    private CollaboratorDao service;

    @Override
    public AppCollaborator save(AppCollaborator coll) {
        return service.save(coll);
    }

    @Override
    public AppCollaborator update(AppCollaborator coll) {
        return service.update(coll);
    }

    @Override
    public void delete(long id) {
        AppCollaborator coll =  service.findById(id);
        if(coll!=null){
            service.delete(coll);
        }
    }

    @Override
    public AppCollaborator findById(long id) {
        return service.findById(id);
    }

    @Override
    public AppCollaborator findByEmail(String email) {
        return service.findByEmail(email);
    }

    @Override
    public Iterable<AppCollaborator> findAll() {
        return service.findAll();
    }
    
}
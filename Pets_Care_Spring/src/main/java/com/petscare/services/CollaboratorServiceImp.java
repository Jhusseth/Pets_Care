package com.petscare.services;

import com.petscare.dao.CollaboratorDao;
import com.petscare.model.Collaborator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorServiceImp implements CollaboratorService {

    @Autowired
    private CollaboratorDao service;

    @Override
    public Collaborator save(Collaborator coll) {
        return service.save(coll);
    }

    @Override
    public Collaborator update(Collaborator coll) {
        return service.update(coll);
    }

    @Override
    public void delete(long id) {
        Collaborator coll =  service.findById(id);
        if(coll!=null){
            service.delete(coll);
        }
    }

    @Override
    public Collaborator findById(long id) {
        return service.findById(id);
    }

    @Override
    public Collaborator findByEmail(String email) {
        return service.findByEmail(email);
    }

    @Override
    public Iterable<Collaborator> findAll() {
        return service.findAll();
    }
    
}
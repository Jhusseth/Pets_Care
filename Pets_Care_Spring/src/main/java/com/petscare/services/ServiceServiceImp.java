package com.petscare.services;

import org.springframework.stereotype.Service;
import com.petscare.dao.CollaboratorDao;
import com.petscare.dao.ServiceDao;
import com.petscare.model.Collaborator;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ServiceServiceImp implements ServiceService {

    @Autowired
    private ServiceDao service;

    @Autowired
    private CollaboratorDao coll;

    @Override
    public com.petscare.model.Service save(long id,com.petscare.model.Service service) {

        Collaborator col = coll.findById(id);
        if(col!=null){
            service.setCollaborator(col);
            //col.getServices().add(service);
            coll.update(col);
            return this.service.save(service);
        }

        return null;
    }

    @Override
    public com.petscare.model.Service update(com.petscare.model.Service service) {

        if(service!=null){
            service.setCollaborator(this.service.findById(service.getId()).getCollaborator());     
            return this.service.update(service);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        com.petscare.model.Service ser = this.service.findById(id);
        ser.setCollaborator(null);
        this.service.delete(ser);
    }

    @Override
    public com.petscare.model.Service findById(long id) {
        return this.service.findById(id);
    }

    @Override
    public Iterable<com.petscare.model.Service> findByCollaborator(long id) {
        Collaborator col = coll.findById(id);
        if(col!=null){
            return this.service.findByCollaborator(col);
        }
        return null;
        
    }

    @Override
    public Iterable<com.petscare.model.Service> findAll() {
        return this.service.findAll();
    }
    
}
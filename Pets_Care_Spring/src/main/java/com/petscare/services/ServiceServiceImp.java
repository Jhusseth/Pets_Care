package com.petscare.services;

import com.petscare.model.AppService;
import org.springframework.stereotype.Service;
import com.petscare.dao.CollaboratorDao;
import com.petscare.dao.ServiceDao;
import com.petscare.model.AppCollaborator;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ServiceServiceImp implements ServiceService {

    @Autowired
    private ServiceDao service;

    @Autowired
    private CollaboratorDao coll;

    @Override
    public AppService save(long id, AppService appService) {

        AppCollaborator col = coll.findById(id);
        if(col!=null){
            appService.setAppCollaborator(col);
            col.getServices().add(appService);
            coll.update(col);
            return this.service.save(appService);
        }

        return null;
    }

    @Override
    public AppService update(AppService appService) {

        if (appService != null) {
            appService.setAppCollaborator(this.service.findById(appService.getId()).getAppCollaborator());
            return this.service.update(appService);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        AppService ser = this.service.findById(id);
        ser.setAppCollaborator(null);
        this.service.delete(ser);
    }

    @Override
    public AppService findById(long id) {
        return this.service.findById(id);
    }

    @Override
    public Iterable<AppService> findByCollaborator(long id) {
        AppCollaborator col = coll.findById(id);
        if(col!=null){
            return this.service.findByCollaborator(col);
        }
        return null;
        
    }

    @Override
    public Iterable<AppService> findAll() {
        return this.service.findAll();
    }
    
}
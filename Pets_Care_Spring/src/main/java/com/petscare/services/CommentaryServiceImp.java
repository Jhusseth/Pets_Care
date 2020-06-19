package com.petscare.services;

import com.petscare.dao.CommentaryDao;
import com.petscare.dao.ServiceDao;
import com.petscare.model.Commentary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaryServiceImp implements CommentaryService {

    @Autowired
    private CommentaryDao service;

    @Autowired
    private ServiceDao serviceDao;

    @Override
    public Commentary save(long id,Commentary comment) {
        com.petscare.model.Service srv = serviceDao.findById(id);
        if(srv!=null){
            //srv.getCommentaries().add(comment);
            comment.setService(srv);
            serviceDao.update(srv);
            return service.save(comment);
        }
        return null;
    }

    @Override
    public Commentary update(Commentary comment){
        if(comment!=null){
            comment.setService(serviceDao.findById(comment.getService().getId()));
            return service.update(comment);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        Commentary comm = service.findById(id);
        if(comm!=null){
            service.delete(comm);
        }
    }

    @Override
    public Commentary findById(long id) {
        return service.findById(id);
    }

    @Override
    public Iterable<Commentary> findByUser(long id) {
        return service.findByUser(id);
    }

    @Override
    public Iterable<Commentary> findByService(long id) {
        return service.findByService(id);
    }

    @Override
    public Iterable<Commentary> findAll() {
        return service.findAll();
    }

    
    
}
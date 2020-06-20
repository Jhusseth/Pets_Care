package com.petscare.services;

import com.petscare.dao.CommentaryDao;
import com.petscare.dao.ServiceDao;
import com.petscare.model.AppService;
import com.petscare.model.AppServiceCommentary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaryServiceImp implements CommentaryService {

    @Autowired
    private CommentaryDao service;

    @Autowired
    private ServiceDao serviceDao;

    @Override
    public AppServiceCommentary save(long id, AppServiceCommentary comment) {
        AppService srv = serviceDao.findById(id);
        if(srv!=null){
            srv.getCommentaries().add(comment);
            comment.setAppService(srv);
            serviceDao.update(srv);
            return service.save(comment);
        }
        return null;
    }

    @Override
    public AppServiceCommentary update(AppServiceCommentary comment){
        if(comment!=null){
            comment.setAppService(serviceDao.findById(comment.getAppService().getId()));
            return service.update(comment);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        AppServiceCommentary comm = service.findById(id);
        if(comm!=null){
            service.delete(comm);
        }
    }

    @Override
    public AppServiceCommentary findById(long id) {
        return service.findById(id);
    }

    @Override
    public Iterable<AppServiceCommentary> findByUser(long id) {
        return service.findByUser(id);
    }

    @Override
    public Iterable<AppServiceCommentary> findByService(long id) {
        return service.findByService(id);
    }

    @Override
    public Iterable<AppServiceCommentary> findAll() {
        return service.findAll();
    }

    
    
}
package com.petscare.restControllers;

import com.petscare.model.AppServiceCommentary;

public interface CommentaryRestController {

    public AppServiceCommentary save(long id, AppServiceCommentary comment);
    public AppServiceCommentary update(AppServiceCommentary comment);
    public void delete(long id);
    public AppServiceCommentary findById(long id);
    public Iterable<AppServiceCommentary> findByUser(long id);
    public Iterable<AppServiceCommentary> findByService(long id);
    public Iterable<AppServiceCommentary> findAll();
    
}
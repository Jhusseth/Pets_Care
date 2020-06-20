package com.petscare.services;

import com.petscare.model.AppServiceCommentary;

public interface CommentaryService {

    public AppServiceCommentary save(long id, AppServiceCommentary comment);
    public AppServiceCommentary update(AppServiceCommentary comment);
    public void delete(long id);
    public AppServiceCommentary findById(long id);
    public Iterable<AppServiceCommentary> findByUser(long id);
    public Iterable<AppServiceCommentary> findByService(long id);
    public Iterable<AppServiceCommentary> findAll();
    
}
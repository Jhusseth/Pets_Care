package com.petscare.dao;

import com.petscare.model.AppServiceCommentary;

public interface CommentaryDao {

    public AppServiceCommentary save (AppServiceCommentary comment);
    public AppServiceCommentary update (AppServiceCommentary comment);
    public void delete (AppServiceCommentary comment);
    public AppServiceCommentary findById(long id);
    public Iterable<AppServiceCommentary> findByUser(long id);
    public Iterable<AppServiceCommentary> findByService(long id);
    public Iterable<AppServiceCommentary> findAll();
    
}
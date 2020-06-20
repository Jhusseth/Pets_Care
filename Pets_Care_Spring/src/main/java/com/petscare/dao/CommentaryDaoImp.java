package com.petscare.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.petscare.model.AppServiceCommentary;

import org.springframework.stereotype.Repository;

@Repository
public class CommentaryDaoImp implements CommentaryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AppServiceCommentary save(AppServiceCommentary comment) {
        entityManager.persist(comment);
        return comment;
    }

    @Override
    public AppServiceCommentary update(AppServiceCommentary comment) {
        entityManager.merge(comment);
        return comment;
    }

    @Override
    public void delete(AppServiceCommentary comment) {
        entityManager.remove(comment);
    }

    @Override
    public AppServiceCommentary findById(long id) {
        return entityManager.getReference(AppServiceCommentary.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<AppServiceCommentary> findByUser(long id) {
        return entityManager.createQuery("SELECT user FROM COMMENTARY WHERE user.id = " + id).getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<AppServiceCommentary> findByService(long id) {
        return entityManager.createQuery("SELECT service FROM COMMENTARY WHERE service.id = " +id).getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<AppServiceCommentary> findAll() {
        return entityManager.createQuery("SELECT * FROM COMMENTARY").getResultList();
    }

    


    
}
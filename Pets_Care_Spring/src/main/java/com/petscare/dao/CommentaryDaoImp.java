package com.petscare.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.petscare.model.Commentary;

import org.springframework.stereotype.Repository;

@Repository
public class CommentaryDaoImp implements CommentaryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Commentary save(Commentary comment) {
        entityManager.persist(comment);
        return comment;
    }

    @Override
    public Commentary update(Commentary comment) {
        entityManager.merge(comment);
        return comment;
    }

    @Override
    public void delete(Commentary comment) {
        entityManager.remove(comment);
    }

    @Override
    public Commentary findById(long id) {   
        return entityManager.getReference(Commentary.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Commentary> findByUser(long id) {
        return entityManager.createQuery("SELECT user FROM COMMENTARY WHERE user.id = " + id).getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Commentary> findByService(long id) {
        return entityManager.createQuery("SELECT service FROM COMMENTARY WHERE service.id = " +id).getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Commentary> findAll() {
        return entityManager.createQuery("SELECT * FROM COMMENTARY").getResultList();
    }

    


    
}
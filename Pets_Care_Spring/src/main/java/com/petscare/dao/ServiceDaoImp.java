package com.petscare.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.petscare.model.AppCollaborator;
import com.petscare.model.AppService;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ServiceDaoImp implements ServiceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AppService save(AppService appService) {
        entityManager.persist(appService);
        return appService;
    }

    @Override
    public AppService update(AppService appService) {
        entityManager.merge(appService);
        return appService;
    }

    @Override
    public void delete(AppService appService) {
        entityManager.remove(appService);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<AppService> findAll() {
        return entityManager.createQuery("SELECT * FROM SERVICE").getResultList();
    }

    @Override
    public AppService findById(long id) {
        return entityManager.getReference(AppService.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<AppService> findByCollaborator(AppCollaborator coll) {
        return  entityManager
                .createQuery("SELECT Collaborator FROM SERVICE  WHERE collaborator.id = " + coll.getId())
                .getResultList();
    }


    
}
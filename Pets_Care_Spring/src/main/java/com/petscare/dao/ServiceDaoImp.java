package com.petscare.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.petscare.model.Collaborator;
import com.petscare.model.Service;

import org.springframework.stereotype.Repository;

@Repository
public class ServiceDaoImp implements ServiceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Service save(Service service) {
        entityManager.persist(service);
        return service;
    }

    @Override
    public Service update(Service service) {
        entityManager.merge(service);
        return service;
    }

    @Override
    public void delete(Service service) {
        entityManager.remove(service);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Service> findAll() {
        return entityManager.createQuery("SELECT * FROM SERVICE").getResultList();
    }

    @Override
    public Service findById(long id) {
        return entityManager.getReference(Service.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Service> findByCollaborator(Collaborator coll) {
        return  entityManager
                .createQuery("SELECT Collaborator FROM SERVICE  WHERE collaborator.id = " + coll.getId())
                .getResultList();
    }


    
}
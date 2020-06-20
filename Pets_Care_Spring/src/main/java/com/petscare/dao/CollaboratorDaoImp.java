package com.petscare.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.petscare.model.AppCollaborator;

import org.springframework.stereotype.Repository;

@Repository
public class CollaboratorDaoImp implements CollaboratorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AppCollaborator save(AppCollaborator coll) {
        entityManager.persist(coll);
        return coll;
    }

    @Override
    public AppCollaborator update(AppCollaborator coll) {
        entityManager.merge(coll);
        return coll;
    }

    @Override
    public void delete(AppCollaborator coll) {
        entityManager.remove(coll);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<AppCollaborator> findAll() {
        return entityManager.createQuery("SELECT * FROM COLLABORATOR").getResultList();
    }

    @Override
    public AppCollaborator findByEmail(String email) {
        return (AppCollaborator) entityManager.createQuery("SELECT Email FROM COLLABORATOR WHERE  Email = " + email)
                .getSingleResult();
    }

    @Override
    public AppCollaborator findById(long id) {
        return entityManager.getReference(AppCollaborator.class, id);
    }



    
}
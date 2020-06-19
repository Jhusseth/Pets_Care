package com.petscare.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.petscare.model.Collaborator;

import org.springframework.stereotype.Repository;

@Repository
public class CollaboratorDaoImp implements CollaboratorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collaborator save(Collaborator coll) {
        entityManager.persist(coll);
        return coll;
    }

    @Override
    public Collaborator update(Collaborator coll) {
        entityManager.merge(coll);
        return coll;
    }

    @Override
    public void delete(Collaborator coll) {
        entityManager.remove(coll);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Collaborator> findAll() {
        return entityManager.createQuery("SELECT * FROM COLLABORATOR").getResultList();
    }

    @Override
    public Collaborator findByEmail(String email) {
        return (Collaborator) entityManager.createQuery("SELECT Email FROM COLLABORATOR WHERE  Email = " + email)
                .getSingleResult();
    }

    @Override
    public Collaborator findById(long id) {
        return entityManager.getReference(Collaborator.class, id);
    }



    
}
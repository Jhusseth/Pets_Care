package com.petscare.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.petscare.model.AppUser;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
@Scope("singleton")
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AppUser save(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    public AppUser update(AppUser appUser) {
        entityManager.merge(appUser);
        return appUser;
    }

    @Override
    public void delete(AppUser appUser) {
        entityManager.remove(appUser);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<AppUser> findAll() {
        Iterable<AppUser> query = entityManager.createQuery("SELECT * FROM USERS").getResultList();
        return query;
    }

    @Override
    public AppUser findByEmail(String email) {
        AppUser query =  (AppUser) entityManager.createQuery("SELECT Email FROM USER WHERE Email = " + email).getSingleResult();
        return query;
    }

    @Override
    public AppUser findById(long id) {
        return entityManager.getReference(AppUser.class, id);
    }
    
}
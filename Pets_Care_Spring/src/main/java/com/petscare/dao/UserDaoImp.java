package com.petscare.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.petscare.model.User;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User update(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<User> findAll() {
        Iterable<User> query = entityManager.createQuery("SELECT * FROM USERS").getResultList();
        return query;
    }

    @Override
    public User findByEmail(String email) {
        User query =  (User) entityManager.createQuery("SELECT Email FROM USER WHERE Email = " + email).getSingleResult();
        return query;
    }

    @Override
    public User findById(long id) {
        return entityManager.getReference(User.class, id);
    }
    
}
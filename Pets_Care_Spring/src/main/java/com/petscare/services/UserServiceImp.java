package com.petscare.services;

import com.petscare.dao.UserDao;
import com.petscare.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public void delete(long id) {
        User user = findById(id);
        if(user!=null){
            userDao.delete(user);
        }
    }  

    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }

    @Override
    public User findByEmail(String email) {   
        return userDao.findByEmail(email);
    }

    @Override
    public Iterable<User> findAll() {   
        return userDao.findAll();
    }

    
    
}
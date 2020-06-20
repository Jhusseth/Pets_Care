package com.petscare.services;

import com.petscare.dao.UserDao;
import com.petscare.model.AppUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public AppUser save(AppUser appUser) {
        return userDao.save(appUser);
    }

    @Override
    public AppUser update(AppUser appUser) {
        return userDao.update(appUser);
    }

    @Override
    public void delete(long id) {
        AppUser appUser = findById(id);
        if(appUser !=null){
            userDao.delete(appUser);
        }
    }  

    @Override
    public AppUser findById(long id) {
        return userDao.findById(id);
    }

    @Override
    public AppUser findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public Iterable<AppUser> findAll() {
        return userDao.findAll();
    }

    
    
}
package com.petscare.dao;

import com.petscare.model.AppUser;

public interface UserDao {

    public AppUser save(AppUser appUser);
    public AppUser update(AppUser appUser);
    public void delete(AppUser appUser);
    public AppUser findById(long id);
    public Iterable<AppUser> findAll();
    public AppUser findByEmail(String email);
}
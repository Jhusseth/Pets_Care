package com.petscare.services;

import com.petscare.model.AppUser;

public interface UserService {

    public AppUser save(AppUser appUser);
    public AppUser update(AppUser appUser);
    public void delete(long id);
    public AppUser findById(long id);
    public AppUser findByEmail(String email);
    public Iterable<AppUser> findAll();
 
}
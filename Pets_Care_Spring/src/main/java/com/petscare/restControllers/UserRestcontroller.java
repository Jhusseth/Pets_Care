package com.petscare.restControllers;

import com.petscare.model.AppUser;

public interface UserRestcontroller {

    public AppUser save(AppUser appUser);
    public AppUser update(AppUser appUser);
    public void delete(long id);
    public AppUser findByEmail(String email);
    public AppUser findById(long id);
    public Iterable<AppUser> findByAll();
    
}
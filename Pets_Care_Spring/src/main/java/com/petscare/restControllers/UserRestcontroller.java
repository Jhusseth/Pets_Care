package com.petscare.restControllers;

import com.petscare.model.User;

public interface UserRestcontroller {

    public User save(User user);
    public User update(User user);
    public void delete(long id);
    public User findByEmail(String email);
    public User findById(long id);
    public Iterable<User> findByAll();
    
}
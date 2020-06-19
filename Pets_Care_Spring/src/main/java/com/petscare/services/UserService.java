package com.petscare.services;

import com.petscare.model.User;

public interface UserService {

    public User save(User user);
    public User update(User user);
    public void delete(long id);
    public User findById(long id);
    public User findByEmail(String email);
    public Iterable<User> findAll();
 
}
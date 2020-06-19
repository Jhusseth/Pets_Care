package com.petscare.dao;

import com.petscare.model.User;
public interface UserDao {

    public User save(User user);
    public User update(User user);
    public void delete(User user);
    public User findById(long id);
    public Iterable<User> findAll();
    public User findByEmail(String email);
}
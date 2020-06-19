package com.petscare.restControllers;

import com.petscare.model.User;
import com.petscare.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRestControllerImp implements UserRestcontroller {

    @Autowired
    private UserService service;

    @Override
    @PostMapping("/users")
    public User save(@RequestBody User user) {
        return service.save(user);
    }

    @Override
    @PutMapping("/users")
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    @Override
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @Override
    @GetMapping("/users/{email}")
    public User findByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }

    @Override
    @GetMapping("/users/{id}")
    public User findById(@PathVariable long id) {
        return service.findById(id);
    }

    @Override
    @GetMapping("/users")
    public Iterable<User> findByAll() { 
        return service.findAll();
    }

    
    
}
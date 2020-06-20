package com.petscare.restControllers;

import com.petscare.model.AppUser;
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
    public AppUser save(@RequestBody AppUser appUser) {
        return service.save(appUser);
    }

    @Override
    @PutMapping("/users")
    public AppUser update(@RequestBody AppUser appUser) {
        return service.update(appUser);
    }

    @Override
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @Override
    @GetMapping("/users/{email}")
    public AppUser findByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }

    @Override
    @GetMapping("/users/{id}")
    public AppUser findById(@PathVariable long id) {
        return service.findById(id);
    }

    @Override
    @GetMapping("/users")
    public Iterable<AppUser> findByAll() {
        return service.findAll();
    }

    
    
}
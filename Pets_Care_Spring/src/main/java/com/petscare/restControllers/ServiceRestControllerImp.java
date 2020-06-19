package com.petscare.restControllers;

import com.petscare.model.Service;
import com.petscare.services.ServiceService;

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
public class ServiceRestControllerImp implements ServiceRestController {

    @Autowired
    private ServiceService service;

    @Override
    @PostMapping("/{id}/services")
    public Service save(@PathVariable long id,@RequestBody Service service) {
        return this.service.save(id, service);
    }

    @Override
    @PutMapping("/services")
    public Service update(@RequestBody Service service) {
        return this.service.update(service);
    }

    @Override
    @DeleteMapping("/services/{id}")
    public void delete(@PathVariable long id) {
        this.service.delete(id);
    }

    @Override
    @GetMapping("/services/{id}")
    public Service findById(@PathVariable long id) {
        return this.service.findById(id);
    }

    @Override
    @GetMapping("/{id}/services")
    public Iterable<Service> findByCollaborator(@PathVariable long id) {
        return this.service.findByCollaborator(id);
    }

    @Override
    @GetMapping("/services")
    public Iterable<Service> findAll() {
        return this.findAll();
    }
    
}
package com.petscare.restControllers;

import com.petscare.model.AppCollaborator;
import com.petscare.services.CollaboratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CollaboratorRestControllerImp implements CollaboratorRestController {

    @Autowired
    private CollaboratorService service;

    @Override
    @PostMapping("/collaborators")
    public AppCollaborator save(@RequestBody AppCollaborator coll) {
        return service.save(coll);
    }

    @Override
    @PutMapping("/collaborators")
    public AppCollaborator update(@RequestBody AppCollaborator coll) {
        return service.update(coll);
    }

    @Override
    @PutMapping("/collaborators/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @Override
    @GetMapping("/collaborators/{id}")
    public AppCollaborator findById(@PathVariable long id) {
        return service.findById(id);
    }

    @Override
    @GetMapping("/collaborators/{email}")
    public AppCollaborator findByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }

    @Override
    @GetMapping("/collaborators")
    public Iterable<AppCollaborator> findAll() {
        return service.findAll();
    }
    
}
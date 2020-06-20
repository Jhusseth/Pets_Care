package com.petscare.restControllers;

import com.petscare.model.AppServiceCommentary;
import com.petscare.services.CommentaryService;

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
public class CommentaryRestControllerImp implements CommentaryRestController {

    @Autowired
    private CommentaryService service;

    @Override
    @PostMapping("{id}/comments")
    public AppServiceCommentary save(@PathVariable long id, @RequestBody AppServiceCommentary comment) {
        return service.save(id, comment);
    }

    @Override
    @PutMapping("/comments")
    public AppServiceCommentary update(@RequestBody AppServiceCommentary comment) {
        return service.update(comment);
    }

    @Override
    @DeleteMapping("/comments/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @Override
    @GetMapping("/comments/{id}")
    public AppServiceCommentary findById(@PathVariable  long id) {
        return service.findById(id);
    }

    @Override
    @GetMapping("/comments/user/{id}")
    public Iterable<AppServiceCommentary> findByUser(@PathVariable  long id) {
        return service.findByUser(id);
    }

    @Override
    @GetMapping("/comments/service/{id}")
    public Iterable<AppServiceCommentary> findByService(@PathVariable  long id) {
        return service.findByService(id);
    }

    @Override
    @GetMapping("/comments")
    public Iterable<AppServiceCommentary> findAll() {
        return service.findAll();
    }
}
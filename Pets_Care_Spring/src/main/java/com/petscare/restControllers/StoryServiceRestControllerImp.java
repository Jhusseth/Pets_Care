package com.petscare.restControllers;

import java.time.LocalDate;

import com.petscare.model.StoryService;
import com.petscare.services.StoryServiceService;

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
public class StoryServiceRestControllerImp implements StoryServiceRestController {

    @Autowired
    private StoryServiceService service;

    @Override
    @PostMapping("{id}/record")
    public StoryService save(@PathVariable long id, @RequestBody StoryService storyService) {
        return service.save(id, storyService);
    }

    @Override
    @PutMapping("/record")
    public StoryService update(@RequestBody StoryService storyService) {
        return service.update(storyService);
    }

    @Override
    @DeleteMapping("/record/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @Override
    @GetMapping("/record/{id}")
    public StoryService findById(@PathVariable long id) {
        return service.findById(id);
    }

    @Override
    @GetMapping("/record/query")
    public Iterable<StoryService> findByDate(@PathVariable LocalDate date1, @PathVariable LocalDate date2) {
        return service.findByDate(date1, date2);
    }

    @Override
    @GetMapping("/record")
    public Iterable<StoryService> findAll() {
        return service.findAll();
    }
    
}
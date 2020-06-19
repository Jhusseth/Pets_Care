package com.petscare.restControllers;

import java.time.LocalDate;

import com.petscare.model.StoryService;

public interface StoryServiceRestController {

    public StoryService save(long id,StoryService storyService);
    public StoryService update(StoryService storyService);
    public void delete(long id);
    public StoryService findById(long id);
    public Iterable<StoryService> findByDate(LocalDate date1,LocalDate date2);
    public Iterable<StoryService> findAll();
    
}
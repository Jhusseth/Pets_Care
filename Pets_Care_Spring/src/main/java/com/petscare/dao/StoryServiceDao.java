package com.petscare.dao;

import java.time.LocalDate;

import com.petscare.model.StoryService;

public interface StoryServiceDao {

    public StoryService save (StoryService storyService);
    public StoryService update (StoryService storyService);
    public void delete (StoryService storyService);
    public StoryService findById(long id);
    public Iterable<StoryService> findByDate(LocalDate date1,LocalDate date2);
    public Iterable<StoryService> findByAll();

}
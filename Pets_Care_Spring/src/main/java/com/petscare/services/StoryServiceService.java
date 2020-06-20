package com.petscare.services;

import java.time.LocalDate;

import com.petscare.model.AppStoryService;

public interface StoryServiceService {

    public AppStoryService save(long id, AppStoryService appStoryService);
    public AppStoryService update(AppStoryService appStoryService);
    public void delete(long id);
    public AppStoryService findById(long id);
    public Iterable<AppStoryService> findByDate(LocalDate date1, LocalDate date2);
    public Iterable<AppStoryService> findAll();
    
}
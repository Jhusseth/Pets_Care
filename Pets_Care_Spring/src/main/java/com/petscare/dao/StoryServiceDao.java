package com.petscare.dao;

import java.time.LocalDate;

import com.petscare.model.AppStoryService;

public interface StoryServiceDao {

    public AppStoryService save (AppStoryService appStoryService);
    public AppStoryService update (AppStoryService appStoryService);
    public void delete (AppStoryService appStoryService);
    public AppStoryService findById(long id);
    public Iterable<AppStoryService> findByDate(LocalDate date1, LocalDate date2);
    public Iterable<AppStoryService> findByAll();

}
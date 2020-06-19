package com.petscare.services;

import java.time.LocalDate;

import com.petscare.dao.StoryServiceDao;
import com.petscare.model.StoryService;
import com.petscare.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryServiceServiceImp implements StoryServiceService {

    @Autowired
    private StoryServiceDao service;

    @Autowired
    private UserService userService;

    @Override
    public StoryService save(long id,StoryService storyService) {
        User usr = userService.findById(id);
        if(usr!=null){
            storyService.setUser(usr);
            //usr.setStoryServices(storyService);
            userService.update(usr);
            return service.save(storyService);
        }
        return null;
        
    }

    @Override
    public StoryService update(StoryService storyService) {
        if(storyService!=null){
            storyService.setUser(service.findById(storyService.getId()).getUser());
            return service.update(storyService);
        }

        return null;
    }

    @Override
    public void delete(long id) {
        StoryService sts = service.findById(id);
        if(sts!=null){
            sts.setUser(null);
            service.delete(sts);
        }
    }

    @Override
    public StoryService findById(long id) {
        return service.findById(id);
    }

    @Override
    public Iterable<StoryService> findByDate(LocalDate date1, LocalDate date2) {
        return service.findByDate(date1, date2);
    }

    @Override
    public Iterable<StoryService> findAll() {
        return service.findByAll();
    }
    
    
}
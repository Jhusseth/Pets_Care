package com.petscare.services;

import java.time.LocalDate;

import com.petscare.dao.StoryServiceDao;
import com.petscare.model.AppStoryService;
import com.petscare.model.AppUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryServiceServiceImp implements StoryServiceService {

    @Autowired
    private StoryServiceDao service;

    @Autowired
    private UserService userService;

    @Override
    public AppStoryService save(long id, AppStoryService appStoryService) {
        AppUser usr = userService.findById(id);
        if(usr!=null){
            appStoryService.setAppUser(usr);
            usr.setStoryServices(appStoryService);
            userService.update(usr);
            return service.save(appStoryService);
        }
        return null;

    }

    @Override
    public AppStoryService update(AppStoryService appStoryService) {
        if (appStoryService != null) {
            appStoryService.setAppUser(service.findById(appStoryService.getId()).getAppUser());
            return service.update(appStoryService);
        }

        return null;
    }

    @Override
    public void delete(long id) {
        AppStoryService sts = service.findById(id);
        if (sts != null) {
            sts.setAppUser(null);
            service.delete(sts);
        }
    }

    @Override
    public AppStoryService findById(long id) {
        return service.findById(id);
    }

    @Override
    public Iterable<AppStoryService> findByDate(LocalDate date1, LocalDate date2) {
        return service.findByDate(date1, date2);
    }

    @Override
    public Iterable<AppStoryService> findAll() {
        return service.findByAll();
    }
    
    
}
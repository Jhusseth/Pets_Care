package com.petscare.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.petscare.model.AppStoryService;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StoryServiceDaoImp implements StoryServiceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AppStoryService save(AppStoryService appStoryService) {
        entityManager.persist(appStoryService);
        return appStoryService;
    }

    @Override
    public AppStoryService update(AppStoryService appStoryService) {
        entityManager.merge(appStoryService);
        return appStoryService;
    }

    @Override
    public void delete(AppStoryService appStoryService) {
        entityManager.remove(appStoryService);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<AppStoryService> findByDate(LocalDate date1, LocalDate date2) {
        return  entityManager.createQuery("SELECT Date FROM STORY_SERVICE WHERE Date BETWEEN Date>=" + date1 + "AND Date<=" + date2)
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<AppStoryService> findByAll() {
        return entityManager.createQuery("SELECT * FROM STORY_SERVICE").getResultList();
    }

    @Override
    public AppStoryService findById(long id) {
        return entityManager.getReference(AppStoryService.class, id);
    }

    
    
}
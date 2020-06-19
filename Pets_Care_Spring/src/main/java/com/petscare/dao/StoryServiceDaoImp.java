package com.petscare.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.petscare.model.StoryService;

import org.springframework.stereotype.Repository;

@Repository
public class StoryServiceDaoImp implements StoryServiceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public StoryService save(StoryService storyService) {
        entityManager.persist(storyService);
        return storyService;
    }

    @Override
    public StoryService update(StoryService storyService) {
        entityManager.merge(storyService);
        return storyService;
    }

    @Override
    public void delete(StoryService storyService) {
        entityManager.remove(storyService);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<StoryService> findByDate(LocalDate date1,LocalDate date2) {
        return  entityManager.createQuery("SELECT Date FROM STORY_SERVICE WHERE Date BETWEEN Date>=" + date1 + "AND Date<=" + date2)
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<StoryService> findByAll() {
        return entityManager.createQuery("SELECT * FROM STORY_SERVICE").getResultList();
    }

    @Override
    public StoryService findById(long id) {
        return entityManager.getReference(StoryService.class, id);
    }

    
    
}
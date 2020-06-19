package com.petscare.dao;

import com.petscare.model.Collaborator;
import com.petscare.model.Service;

public interface ServiceDao {

    public Service save(Service service);
    public Service update(Service service);
    public void delete(Service service);
    public Iterable<Service> findAll();
    public Service findById(long id);
    public Iterable<Service> findByCollaborator(Collaborator coll);
    
}
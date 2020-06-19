package com.petscare.services;

import com.petscare.model.Service;

public interface ServiceService {
    
    public Service save(long id, Service service);
    public Service update (Service service);
    public void delete(long id);
    public Service findById(long id);
    public Iterable<Service> findByCollaborator(long id);
    public Iterable<Service> findAll();

}
package com.rossreicks.starter.services;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class ServiceBase<DBModel> {
    private final CrudRepository<DBModel, Long> repository;
    
    public ServiceBase(CrudRepository<DBModel, Long> repo)
    {
        this.repository = repo;
    }

    public Iterable<DBModel> GetAll() {
        return repository.findAll();
    }

    public Optional<DBModel> Get(long Id) {
        return repository.findById(Id);
    }

    public void Add(DBModel model) {
        repository.save(model);
    }

    public void Delete(long id) {
        repository.delete(Get(id).get());
    }

    public void Update(long id, DBModel model) {
        Add(model);
    }
}
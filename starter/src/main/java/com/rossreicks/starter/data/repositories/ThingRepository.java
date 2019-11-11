package com.rossreicks.starter.data.repositories;

import java.util.List;

import com.rossreicks.starter.data.entities.Thing;

import org.springframework.data.repository.CrudRepository;

public interface ThingRepository extends CrudRepository<Thing, Long> {
    List<Thing> findAll();
}
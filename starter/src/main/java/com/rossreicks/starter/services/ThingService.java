package com.rossreicks.starter.services;

import com.rossreicks.starter.data.entities.Thing;
import com.rossreicks.starter.data.repositories.ThingRepository;

import org.springframework.stereotype.Service;

@Service
public class ThingService extends ServiceBase<Thing> {
    public ThingService(ThingRepository repo) {
        super(repo);
    }
}
package com.rossreicks.starter.controllers;

import com.rossreicks.starter.data.entities.Thing;
import com.rossreicks.starter.mappers.ThingMapper;
import com.rossreicks.starter.models.APIThing;
import com.rossreicks.starter.services.ThingService;
import com.rossreicks.starter.validators.ThingValidator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/thing")
public class ThingController extends ControllerBase<APIThing, Thing> {
    public ThingController(ThingService tService, ThingMapper mapper, ThingValidator validator) {
        super(tService, mapper, validator);
    }
}
package com.rossreicks.starter.mappers;

import com.rossreicks.starter.data.entities.Thing;
import com.rossreicks.starter.models.APIThing;

import org.springframework.stereotype.Component;

@Component
public class ThingMapper extends MapperBase<APIThing, Thing> {
    public ThingMapper() {
        super(APIThing.class, Thing.class);
    }
}
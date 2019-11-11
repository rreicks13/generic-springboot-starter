package com.rossreicks.starter.validators;

import com.rossreicks.starter.models.APIThing;

public class ThingValidator extends ValidatorBase<APIThing>
{

    @Override
    public boolean IsValidModel(APIThing model) {
        if (model == null) return false;
        if (model.getName().isEmpty()) return false;
        return true;
    }
    
}
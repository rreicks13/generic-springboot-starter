package com.rossreicks.starter.validators;

public abstract class ValidatorBase<APIModel> {
    public abstract boolean IsValidModel(APIModel model);
}
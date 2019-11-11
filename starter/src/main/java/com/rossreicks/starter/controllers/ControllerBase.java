package com.rossreicks.starter.controllers;

import java.util.Optional;

import com.rossreicks.starter.mappers.MapperBase;
import com.rossreicks.starter.services.ServiceBase;
import com.rossreicks.starter.validators.ValidatorBase;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public abstract class ControllerBase<APIModel, DBModel> {
    private final ServiceBase<DBModel> service;
    private final MapperBase<APIModel, DBModel> mapper;
    private final ValidatorBase<APIModel> validator;

    public ControllerBase(ServiceBase<DBModel> service, MapperBase<APIModel, DBModel> mapper, ValidatorBase<APIModel> validator) {
        this.service = service;
        this.mapper = mapper;
        this.validator = validator;
    }

    @GetMapping()
    public ResponseEntity<Iterable<APIModel>> Get() {
        return ResponseEntity.ok(mapper.ToAPIList(service.GetAll()));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<APIModel> Get(@PathVariable long id) {
        Optional<DBModel> model = service.Get(id);
        if (!model.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.ToAPIModel(model.get()));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity Add(@RequestBody APIModel model) {
        if (!validator.IsValidModel(model))
        {
            return ResponseEntity.badRequest().build();
        }
        DBModel dbModel = mapper.ToDBModel(model);
        service.Add(dbModel);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity Update(@PathVariable long id, @RequestBody APIModel model) {
        if (!validator.IsValidModel(model))
        {
            return ResponseEntity.badRequest().build();
        }
        DBModel dbModel = mapper.ToDBModel(model);
        service.Update(id, dbModel);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity Delete(@PathVariable long id) {
        service.Delete(id);
        return ResponseEntity.ok().build();
    }
    
}
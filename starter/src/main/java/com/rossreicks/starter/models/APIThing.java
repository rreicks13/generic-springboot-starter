package com.rossreicks.starter.models;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class APIThing {
    private Long id;
    @NotBlank(message = "Things have to have a name")
    private String name;
}
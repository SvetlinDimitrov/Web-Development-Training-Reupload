package com.example.productsshop.entities.Dtos.Json;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDtoSeed {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;
}

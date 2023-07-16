package com.example.cardriver.dtos.json.initDtos;

import com.example.cardriver.entity.Supplier;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDto {

    private String name;

    private Boolean isImporter;

    public Supplier toSupplier(){
        return Supplier.builder()
                .name(name)
                .isImporter(isImporter)
                .build();
    }
}

package com.example.cardriver.dtos.quarry3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SuppliersDtoQuery3 {
    private Integer Id;
    private String Name;
    private Integer partsCount;

    public SuppliersDtoQuery3(Integer id, String name, Integer partsCount) {
        Id = id;
        Name = name;
        this.partsCount = partsCount;
    }
}

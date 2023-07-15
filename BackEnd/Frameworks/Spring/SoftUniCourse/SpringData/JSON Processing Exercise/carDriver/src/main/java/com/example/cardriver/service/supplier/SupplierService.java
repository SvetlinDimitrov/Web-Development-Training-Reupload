package com.example.cardriver.service.supplier;

import com.example.cardriver.dtos.quarry3.SuppliersDtoQuery3;
import com.example.cardriver.entity.Supplier;

import java.util.List;

public interface SupplierService {
    boolean isEmpty();

    void saveSupplier(Supplier c);

    Supplier getRandomSupplier();

    List<SuppliersDtoQuery3> getAllSuppliers();
}

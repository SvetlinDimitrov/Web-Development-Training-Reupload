package com.example.cardriver.service.supplier;

import com.example.cardriver.dtos.json.quarry.SuppliersDtoQuery3;
import com.example.cardriver.dtos.xml.quarry.SupplierDtoQuarry3Xml;
import com.example.cardriver.entity.Supplier;

import java.util.List;

public interface SupplierService {
    boolean isEmpty();

    void saveSupplier(Supplier c);

    Supplier getRandomSupplier();

    List<SuppliersDtoQuery3> getAllSuppliersJson();

    List<SupplierDtoQuarry3Xml> getAllSuppliersXml();
}

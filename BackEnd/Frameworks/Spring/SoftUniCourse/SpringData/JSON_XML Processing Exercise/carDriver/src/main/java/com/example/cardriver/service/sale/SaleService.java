package com.example.cardriver.service.sale;

import com.example.cardriver.dtos.json.quarry.SalesDtoQuarry6;
import com.example.cardriver.dtos.xml.quarry.SaleDtoQuarry6Xml;
import com.example.cardriver.entity.Sale;

import java.util.List;

public interface SaleService {
    boolean isEmpty();

    void saveSale(Sale sale);

    List<SalesDtoQuarry6> getAllSalesWithAppliedDiscountJson();

    List<SaleDtoQuarry6Xml> getAllSalesWithAppliedDiscountXml();
}

package com.example.cardriver.service.sale;

import com.example.cardriver.dtos.quarry6.SalesDtoQuarry6;
import com.example.cardriver.entity.Sale;

import java.util.List;

public interface SaleService {
    boolean isEmpty();

    void saveSale(Sale sale);

    List<SalesDtoQuarry6> getAllSalesWithAppliedDiscount();

}

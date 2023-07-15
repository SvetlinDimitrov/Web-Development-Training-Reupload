package com.example.cardriver.service.sale;

import com.example.cardriver.dtos.quarry6.CarDtoQuarry6;
import com.example.cardriver.dtos.quarry6.SalesDtoQuarry6;
import com.example.cardriver.entity.Part;
import com.example.cardriver.entity.Sale;
import com.example.cardriver.repos.SaleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    private SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public boolean isEmpty() {
        return saleRepository.count() ==0;
    }

    @Override
    public void saveSale(Sale sale) {
        saleRepository.save(sale);
    }

    @Transactional
    @Override
    public List<SalesDtoQuarry6> getAllSalesWithAppliedDiscount() {
        return saleRepository.findAll()
                .stream()
                .map(s->{
                    CarDtoQuarry6 carDtoQuarry6 = new CarDtoQuarry6(s.getCar().getMake(),s.getCar().getModel() ,s.getCar().getTravelledDistance());
                    BigDecimal price = s.getCar()
                            .getParts()
                            .stream()
                            .map(Part::getPrice)
                            .reduce(new BigDecimal(0), BigDecimal::add);

                    SalesDtoQuarry6 salesDtoQuarry6 = new SalesDtoQuarry6(
                            s.getCustomer().getName(),
                            s.getDiscount(),
                            price,
                            price.subtract(price.multiply(BigDecimal.valueOf(s.getDiscount()))));
                    salesDtoQuarry6.setCar(carDtoQuarry6);

                    return salesDtoQuarry6;
                })
                .toList();
    }
}

package com.example.cardriver.service.supplier;

import com.example.cardriver.dtos.quarry3.SuppliersDtoQuery3;
import com.example.cardriver.entity.Supplier;
import com.example.cardriver.repos.SupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;


@Service
public class SupplierServiceImpl implements SupplierService {
    private SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public boolean isEmpty() {
        return supplierRepository.count() == 0;
    }

    @Override
    public void saveSupplier(Supplier c) {
        supplierRepository.save(c);
    }

    @Override
    public Supplier getRandomSupplier() {
        Random random = new Random();
        int n = random.nextInt((int) supplierRepository.count());
        return supplierRepository.getReferenceById(++n);
    }

    @Override
    @Transactional
    public List<SuppliersDtoQuery3> getAllSuppliers() {
        return supplierRepository.findAll()
                .stream().map(s->new SuppliersDtoQuery3(s.getId(),s.getName() , s.getPart().size()))
                .toList();
    }
}

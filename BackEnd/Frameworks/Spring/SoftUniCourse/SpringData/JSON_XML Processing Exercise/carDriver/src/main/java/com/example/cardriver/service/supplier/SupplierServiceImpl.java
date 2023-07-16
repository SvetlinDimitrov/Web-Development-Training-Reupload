package com.example.cardriver.service.supplier;

import com.example.cardriver.dtos.json.quarry.SuppliersDtoQuery3;
import com.example.cardriver.dtos.xml.quarry.SupplierDtoQuarry3Xml;
import com.example.cardriver.entity.Supplier;
import com.example.cardriver.repos.SupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;


@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

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
    public List<SuppliersDtoQuery3> getAllSuppliersJson() {
        return supplierRepository
                .findAll()
                .stream()
                .map(e->new SuppliersDtoQuery3(e.getId(),e.getName(),e.getPart().size()))
                .toList();
    }

    @Override
    @Transactional
    public List<SupplierDtoQuarry3Xml> getAllSuppliersXml() {
        return supplierRepository
                .findAll()
                .stream()
                .map(e->new SupplierDtoQuarry3Xml(e.getId(),e.getName(),e.getPart().size()))
                .toList();
    }
}

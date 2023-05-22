package com.example.cardealer.service.seed;

import com.example.cardealer.domain.entity.Car;
import com.example.cardealer.domain.entity.Customer;
import com.example.cardealer.domain.entity.Part;
import com.example.cardealer.domain.entity.Supplier;
import com.example.cardealer.reporsitroy.*;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.example.cardealer.domain.CONSTANTS.CONSTANTS.*;
import static com.example.cardealer.domain.CONSTANTS.Units.GSON;

@Service
public class SeedServiceImpl implements SeedService {
    private CarRepository carRepository;
    private CustomerRepository customerRepository;
    private SaleRepository saleRepository;
    private PartRepository partRepository;
    private SupplierRepository supplierRepository;

    @Autowired
    public SeedServiceImpl(CarRepository carRepository, CustomerRepository customerRepository, SaleRepository saleRepository, PartRepository partRepository, SupplierRepository supplierRepository) {
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.saleRepository = saleRepository;
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void seedCars() throws FileNotFoundException {
        if(carRepository.count() != 0){
            return;
        }
        Arrays.stream(GSON.fromJson(getFileReader(PATH_SEED_CARS) , Car[].class))
                .forEach(c -> {
                    long length = getRandomId(3, 5) + 1;
                    for (int i = 0; i < length; i++) {
                        Optional<Part> byId = partRepository.findById(getRandomId(1, partRepository.count()));
                        c.getParts().add(byId.get());
                    }
                    carRepository.saveAndFlush(c);
                });
    }

    @Override
    public void seedCustomers() throws FileNotFoundException {
        if(customerRepository.count() != 0){
            return;
        }
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class , new LocalDateTimeSerializer())
                .create();

        List<Customer> list = Arrays.stream(gson.fromJson(getFileReader(PATH_SEED_CUSTOMERS), Customer[].class))
                .toList();
        customerRepository.saveAllAndFlush(list);

    }

    @Override
    public void seedSales() {
        if(saleRepository.count() != 0){
            return;
        }
    }

    @Override
    public void seedParts() throws FileNotFoundException {
        if(partRepository.count() != 0){
            return;
        }
        Arrays.stream(GSON.fromJson(getFileReader(PATH_SEED_PARTS) , Part[].class))
                .forEach( p -> {
                    long supplierId = getRandomId(1 , supplierRepository.count());
                    p.setSuppliers(supplierRepository.findById(supplierId).get());
                    partRepository.saveAndFlush(p);
                });
    }

    private long getRandomId(long low , long high) {
        Random random  = new Random();
        return random.nextLong(low, high) + 1;
    }

    @Override
    public void seedSuppliers() throws FileNotFoundException {
        if(supplierRepository.count() != 0){
            return;
        }
        List<Supplier> suppliers =
                Arrays.stream(GSON.fromJson(getFileReader(PATH_SEED_SUPPLIERS), Supplier[].class))
                .toList();
        supplierRepository.saveAllAndFlush(suppliers);
    }

    private static FileReader getFileReader(String path) throws FileNotFoundException {
        FileReader fileReader = new FileReader(path);
        return fileReader;
    }
}

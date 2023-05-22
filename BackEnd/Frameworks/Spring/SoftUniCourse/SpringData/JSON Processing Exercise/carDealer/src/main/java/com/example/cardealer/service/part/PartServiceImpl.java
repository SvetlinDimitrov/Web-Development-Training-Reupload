package com.example.cardealer.service.part;

import com.example.cardealer.reporsitroy.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartServiceImpl implements PartService {
    private PartRepository partRepository;

    @Autowired
    public PartServiceImpl( PartRepository partRepository) {
        this.partRepository = partRepository;

    }
}

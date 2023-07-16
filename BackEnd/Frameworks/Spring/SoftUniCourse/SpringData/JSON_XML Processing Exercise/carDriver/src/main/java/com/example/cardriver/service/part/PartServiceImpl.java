package com.example.cardriver.service.part;

import com.example.cardriver.entity.Part;
import com.example.cardriver.repos.PartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {
    private PartRepository partRepository;

    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public boolean isEmpty() {
        return partRepository.count() ==0;
    }

    @Override
    public void savePart(Part p) {
        partRepository.save(p);
    }

    @Override
    public List<Part> getRandomParts() {
        return partRepository.getRandomParts();
    }
}

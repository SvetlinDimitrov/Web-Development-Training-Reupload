package com.example.cardriver.service.part;

import com.example.cardriver.entity.Part;

import java.util.List;

public interface PartService {
    boolean isEmpty();

    void savePart(Part p);

    List<Part> getRandomParts();

}

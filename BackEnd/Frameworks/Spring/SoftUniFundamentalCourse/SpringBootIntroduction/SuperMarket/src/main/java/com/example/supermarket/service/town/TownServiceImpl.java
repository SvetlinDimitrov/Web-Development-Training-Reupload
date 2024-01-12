package com.example.supermarket.service.town;

import com.example.supermarket.domain.entity.Town;
import com.example.supermarket.repos.TownRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
public class TownServiceImpl implements TownService {
    private TownRepository townRepository;
    private Validator validator;

    @Override
    public void add(Town town) {
        Set<ConstraintViolation<Town>> validate = validator.validate(town);
        if(validate.isEmpty()){
            townRepository.save(town);
            System.out.println("Successfully added town!");
            return;
        }
        validate.forEach(m->System.out.println(m.getMessage()));
    }
}

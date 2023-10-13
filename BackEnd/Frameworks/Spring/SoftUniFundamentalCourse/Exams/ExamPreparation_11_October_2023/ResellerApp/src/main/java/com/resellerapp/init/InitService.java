package com.resellerapp.init;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.enums.ConditionConstants;
import com.resellerapp.repository.ConditionRepository;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@Data
public class InitService implements CommandLineRunner {

    private final ConditionRepository repository;

    @Override
    public void run(String... args) throws Exception{

        if (repository.count() == 0) {
            Condition condition1 = new Condition();
            condition1.setName(ConditionConstants.EXCELLENT);
            condition1.setDescription("In perfect condition");

            Condition condition2 = new Condition();
            condition2.setName(ConditionConstants.GOOD);
            condition2.setDescription("Some signs of wear and tear or minor defects");

            Condition condition3 = new Condition();
            condition3.setName(ConditionConstants.ACCEPTABLE);
            condition3.setDescription("The item is fairly worn but continues to function properly");

            repository.save(condition1);
            repository.save(condition2);
            repository.save(condition3);
        }
    }
}

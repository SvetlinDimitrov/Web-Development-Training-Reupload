package com.plannerapp.init;

import com.plannerapp.model.entity.PriorityEntity;
import com.plannerapp.model.enums.PriorityConst;
import com.plannerapp.repo.PriorityRepository;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Data
public class Init implements CommandLineRunner {

    private final PriorityRepository priorityRepository;

    @Override
    public void run(String... args){
        if(priorityRepository.count() == 0){
            PriorityEntity priority1 = new PriorityEntity();
            priority1.setName(PriorityConst.LOW);
            priority1.setDescription("Should be fixed if time permits but can be postponed.");

            PriorityEntity priority2 = new PriorityEntity();
            priority2.setName(PriorityConst.IMPORTANT);
            priority2.setDescription("A core functionality that your product is explicitly supposed to perform is compromised.");

            PriorityEntity priority3 = new PriorityEntity();
            priority3.setName(PriorityConst.URGENT);
            priority3.setDescription("An urgent problem that blocks the system use until the issue is resolved.");

            priorityRepository.save(priority1);
            priorityRepository.save(priority2);
            priorityRepository.save(priority3);
        }
    }
}

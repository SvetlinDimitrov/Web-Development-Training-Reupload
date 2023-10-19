package com.plannerapp.init;

import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.enums.PriorityEnum;
import com.plannerapp.repo.PriorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PriorityInit implements CommandLineRunner {

    private final PriorityRepository priorityRepository;

    @Override
    public void run(String... args) throws Exception {
        if(priorityRepository.count() == 0){
            priorityRepository.save(new Priority(PriorityEnum.LOW));
            priorityRepository.save(new Priority(PriorityEnum.IMPORTANT));
            priorityRepository.save(new Priority(PriorityEnum.URGENT));
        }
    }


}

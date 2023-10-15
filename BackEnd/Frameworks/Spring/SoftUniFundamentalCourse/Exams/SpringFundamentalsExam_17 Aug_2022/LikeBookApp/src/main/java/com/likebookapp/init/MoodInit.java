package com.likebookapp.init;

import com.likebookapp.model.entity.MoodEntity;
import com.likebookapp.model.enums.MoodConstance;
import com.likebookapp.repository.MoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MoodInit implements CommandLineRunner {

    private final MoodRepository moodRepository;

    @Override
    public void run(String... args) throws Exception {
        if(moodRepository.count() == 0){
            MoodEntity moodEntity1 = new MoodEntity();
            moodEntity1.setName(MoodConstance.SAD);
            moodEntity1.setDescription("I ama sad");

            MoodEntity moodEntity2 = new MoodEntity();
            moodEntity2.setName(MoodConstance.HAPPY);
            moodEntity2.setDescription("I ama happy");

            MoodEntity moodEntity3 = new MoodEntity();
            moodEntity3.setName(MoodConstance.INSPIRED);
            moodEntity3.setDescription("I ama inspired");

            moodRepository.save(moodEntity1);
            moodRepository.save(moodEntity2);
            moodRepository.save(moodEntity3);

        }
    }
}

package com.example.spotifyplaylistapp.init;

import com.example.spotifyplaylistapp.model.entity.StyleEntity;
import com.example.spotifyplaylistapp.model.enums.StyleConstant;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class InitStyles implements CommandLineRunner {

    private final StyleRepository styleRepository;

    @Override
    public void run(String... args) throws Exception {
        if(styleRepository.count() == 0){
            StyleEntity style1 = new StyleEntity();
            StyleEntity style2 = new StyleEntity();
            StyleEntity style3 = new StyleEntity();

            style1.setDescription("something");
            style1.setName(StyleConstant.JAZZ);
            styleRepository.save(style1);

            style2.setName(StyleConstant.ROCK);
            style2.setDescription("rock is the best pill");
            styleRepository.save(style2);

            style3.setName(StyleConstant.POP);
            style3.setDescription("Pop baby");
            styleRepository.save(style3);
        }
    }
}

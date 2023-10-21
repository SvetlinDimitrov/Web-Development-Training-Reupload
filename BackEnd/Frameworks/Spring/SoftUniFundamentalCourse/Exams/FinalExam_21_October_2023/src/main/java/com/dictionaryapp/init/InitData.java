package com.dictionaryapp.init;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.enums.LanguageConst;
import com.dictionaryapp.repo.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class InitData implements CommandLineRunner {

    private final LanguageRepository languageRepository;

    @Override
    public void run(String... args){
        if (languageRepository.count() == 0) {
            languageRepository.saveAllAndFlush(List.of(
                    new Language(LanguageConst.FRENCH),
                    new Language(LanguageConst.GERMAN),
                    new Language(LanguageConst.SPANISH),
                    new Language(LanguageConst.ITALIAN)
            ));
        }
    }

}

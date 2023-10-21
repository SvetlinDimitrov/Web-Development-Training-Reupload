package com.dictionaryapp.service;

import com.dictionaryapp.model.dtos.WordAddDto;
import com.dictionaryapp.model.dtos.WordView;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageConst;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WordService {

    private final WordRepository wordRepository;
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;

    public void addWord(WordAddDto wordAddDto, String userName) {
        User user = getUserByUsername(userName);
        Language language = languageRepository.findByName(wordAddDto.getLanguage()).orElseThrow(() -> new RuntimeException("No language was found with the name : " + wordAddDto.getLanguage()));

        Word word = wordAddDto.toWord();
        word.setLanguage(language);
        word.setAddedBy(user);
        wordRepository.saveAndFlush(word);

    }

    private User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("No user exist with that name: " + username));
    }

    @Transactional
    public List<WordView> getFrenchWordViews() {
        return wordRepository.findAll()
                .stream()
                .map(WordView::new)
                .filter(wordView -> wordView.getLanguage().equals(LanguageConst.FRENCH))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<WordView> getGermanWordViews() {
        return wordRepository.findAll()
                .stream()
                .map(WordView::new)
                .filter(wordView -> wordView.getLanguage().equals(LanguageConst.GERMAN))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<WordView> getSpanishWordViews() {
        return wordRepository.findAll()
                .stream()
                .map(WordView::new)
                .filter(wordView -> wordView.getLanguage().equals(LanguageConst.SPANISH))
                .collect(Collectors.toList());
    }

    public List<WordView> getItalianWordViews() {
        return wordRepository.findAll()
                .stream()
                .map(WordView::new)
                .filter(wordView -> wordView.getLanguage().equals(LanguageConst.ITALIAN))
                .collect(Collectors.toList());
    }

    @Transactional
    public void removeWordById(Long wordId) {
        Word word = wordRepository.findById(wordId).orElseThrow(() -> new RuntimeException("No Word was found by id :" + wordId));
        wordRepository.delete(word);
    }

    @Transactional
    public void removeAllWords() {
        wordRepository.deleteAll();
    }
}

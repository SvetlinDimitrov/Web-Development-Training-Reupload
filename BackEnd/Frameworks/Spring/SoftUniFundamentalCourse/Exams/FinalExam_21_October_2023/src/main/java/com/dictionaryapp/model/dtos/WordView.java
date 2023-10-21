package com.dictionaryapp.model.dtos;

import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageConst;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordView {

    private Long id;
    private String term;
    private String translation;
    private String example;
    private String inputDate;
    private LanguageConst language;
    private String addedBy;

    public WordView (Word entity){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        this.id = entity.getId();
        this.term = entity.getTerm();
        this.translation = entity.getTranslation();
        this.example = entity.getExample();
        this.inputDate = dateFormat.format(entity.getInputDate());
        this.language = entity.getLanguage().getName();
        this.addedBy = entity.getAddedBy().getUsername();

    }

}

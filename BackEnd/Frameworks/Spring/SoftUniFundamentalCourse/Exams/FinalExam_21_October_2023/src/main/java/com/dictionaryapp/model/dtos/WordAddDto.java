package com.dictionaryapp.model.dtos;

import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageConst;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordAddDto {


    @Size(min = 2 , max = 40 , message = "The term length must be between 2 and 40 characters!")
    private String term;

    @Size(min = 2 , max = 80 , message = "The translation length must be between 2 and 80 characters!")
    private String translation;

    @Size(min = 2 , max = 200 , message = "The example length must be between 2 and 200 characters!")
    private String example;

    @NotNull(message = "The input data must be in the past or present!")
    @PastOrPresent(message = "The input data must be in the past or present!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputDate;

    @NotNull(message = "You must select a language!")
    private LanguageConst language;

    public Word toWord (){
        Word word = new Word();
        word.setTerm(term);
        word.setTranslation(translation);
        word.setExample(example);
        word.setInputDate(inputDate);
        return word;
    }

}

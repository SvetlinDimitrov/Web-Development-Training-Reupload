package com.likebookapp.model.dtos;

import com.likebookapp.model.enums.MoodConstance;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PostCreateDto {

    @NotBlank
    @Length(min = 2 , max = 150)
    private String content;

    @NotNull
    private MoodConstance mood;



}

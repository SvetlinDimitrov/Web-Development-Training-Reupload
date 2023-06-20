package com.example.mobileleweb.domain.viewDtos;

import com.example.mobileleweb.domain.constants.ModelCategory;
import com.example.mobileleweb.domain.entity.Brand;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewModel {

    private String id;
    private String name;
    private ModelCategory category;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
    private LocalDate created;
    private LocalDate modified;
    private Brand brand;

}

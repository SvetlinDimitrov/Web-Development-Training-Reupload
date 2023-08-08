package com.example.pathfinder.domain.dtos;

import com.example.pathfinder.domain.constants.CategoryConstant;
import com.example.pathfinder.domain.constants.Level;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRouteDto {

    @NotBlank
    @Size(min = 3)
    private String name;

    @NotBlank
    @Size(min = 5)
    private String description;

    @NotNull
    private MultipartFile gpxCoordinates;

    @NotNull
    private Level level;

    @NotBlank
    private String videoUrl;


    @NotNull
    private List<CategoryConstant> categories= new ArrayList<>();
    private Long authorId;



}

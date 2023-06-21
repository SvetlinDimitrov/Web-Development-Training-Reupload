package com.example.pathfinder.domain.dtos;

import com.example.pathfinder.domain.constants.CategoryConstant;
import com.example.pathfinder.domain.constants.Level;
import com.example.pathfinder.domain.constants.RoleConstant;
import com.example.pathfinder.domain.entity.Categorie;
import com.example.pathfinder.domain.entity.Picture;
import com.example.pathfinder.domain.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
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

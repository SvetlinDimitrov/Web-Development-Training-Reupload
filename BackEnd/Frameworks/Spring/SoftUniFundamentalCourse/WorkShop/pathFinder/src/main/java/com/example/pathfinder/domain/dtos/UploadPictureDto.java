package com.example.pathfinder.domain.dtos;


import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UploadPictureDto {

    @NotNull
    private MultipartFile picture;
}

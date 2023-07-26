package com.example.mobileleweb.domain.viewDtos;

import com.example.mobileleweb.domain.constants.Engine;
import com.example.mobileleweb.domain.constants.Transmission;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ViewOffer {

    private String id;

    @NotBlank
    private String description;

    @NotNull
    private Engine engine;

    @NotBlank
    private String imageUrl;

    @NotNull
    private Integer mileage;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer year;

    @NotNull
    private Transmission transmission;

    private LocalDate created = LocalDate.now();

    private LocalDate modified = LocalDate.now();

    @NotBlank
    private String modelId;

    private String sellerId;

    private String offerYear_BrandName_OfferName;


}

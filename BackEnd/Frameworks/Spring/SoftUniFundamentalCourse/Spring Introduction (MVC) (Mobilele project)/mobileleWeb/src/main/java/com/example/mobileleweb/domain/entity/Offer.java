package com.example.mobileleweb.domain.entity;

import com.example.mobileleweb.domain.constants.BaseEntity;
import com.example.mobileleweb.domain.constants.Engine;
import com.example.mobileleweb.domain.constants.Transmission;
import com.example.mobileleweb.domain.viewDtos.ViewOfferDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "offers")
public class Offer extends BaseEntity {
    @Column(columnDefinition = "text")
    private String description;

    @Column(columnDefinition = "int(11)")
    @Enumerated
    private Engine engine;

    @Column(name = "image_url", columnDefinition = "varchar(255)")
    private String imageUrl;

    @Column(columnDefinition = "int(11)")
    private Integer mileage;

    @Column(columnDefinition = "decimal(19,2)")
    private BigDecimal price;

    @Column(columnDefinition = "int(11)")
    @Enumerated
    private Transmission transmission;

    @Column(columnDefinition = "int(11)")
    private Integer year;

    @Column(columnDefinition = "datetime(6)")
    private LocalDate created;

    @Column(columnDefinition = "datetime(6)")
    private LocalDate modified;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Model model;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private UserEntity seller;

    public Offer setImgToModelImg() {
        this.setImageUrl(this.getModel().getImageUrl());
        return this;
    }

    public ViewOfferDto toViewOffer() {
        return ViewOfferDto.builder()
                .id(getId())
                .engine(engine)
                .imageUrl(imageUrl)
                .mileage(mileage)
                .description(description)
                .price(price)
                .transmission(transmission)
                .year(year)
                .created(created)
                .modified(modified)
                .modelId(model.getId())
                .sellerId(seller.getId())
                .offerYear_BrandName_OfferName(String.format("%d %s %s", year ,
                        model.getBrand().getName(),
                        model.getName()))
                .build();
    }
}

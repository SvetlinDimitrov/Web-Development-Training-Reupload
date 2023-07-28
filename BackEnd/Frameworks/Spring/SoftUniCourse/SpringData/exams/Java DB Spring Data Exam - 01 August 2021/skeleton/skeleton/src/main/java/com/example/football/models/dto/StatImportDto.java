package com.example.football.models.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "stat")
public class StatImportDto {
    //    • shooting – a floating point number. The value must be positive (larger than 0).
    //    • passing – a floating point number. The value must be positive (larger than 0).
    //    • endurance – a floating point number. The value must be positive (larger than 0).

    @XmlElement
    @NotNull
    @Positive
    @Min(1)
    private Double shooting;

    @XmlElement
    @NotNull
    @Positive
    @Min(1)
    private Double passing;

    @XmlElement
    @NotNull
    @Positive
    @Min(1)
    private Double endurance;
}

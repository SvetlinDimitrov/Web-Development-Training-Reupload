package com.example.football.models.dto;

import com.example.football.util.enums.PositionState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "player")
public class PlayerImportDto {
    //    • first name – accepts char sequences as values where their character length value higher than 2.
    //    • last name – accepts char sequences as values where their character length value higher than 2.
    //    • email – accepts valid email addresses (must contains '@' and '.' – a dot). The values are unique in the database.
    //    • birth date – a date in the "dd/MM/yyyy" format.
    //    • position – one of the following – ATT, MID, DEF.
    //        ◦ Note: The players table has relations with the towns, teams and stats tables.

    @NotBlank
    @Size(min = 2)
    @XmlElement(name = "first-name")
    private String firstName;

    @NotBlank
    @Size(min = 2)
    @XmlElement(name = "last-name")
    private String lastName;

    @NotBlank
    @Email
    @XmlElement
    private String email;

    @NotBlank
    @XmlElement(name = "birth-date")
    private String birthDate;

    @NotNull
    @XmlElement
    private PositionState position;

    @XmlElement(name = "town")
    private TownImportDtoXml town;

    @XmlElement(name = "team")
    private TeamImportDtoXml team;

    @XmlElement(name = "stat")
    private StatImportDtoXml stat;
}

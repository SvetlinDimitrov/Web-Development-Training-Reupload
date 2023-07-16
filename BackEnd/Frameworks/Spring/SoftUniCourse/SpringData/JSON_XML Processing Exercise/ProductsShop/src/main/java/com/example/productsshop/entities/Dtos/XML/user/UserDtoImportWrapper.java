package com.example.productsshop.entities.Dtos.XML.user;

import javax.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class UserDtoImportWrapper {

    @XmlElement(name = "user")
    private List<UserDtoImport> users;
}

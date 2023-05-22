package com.example.productsshop.entities.Dtos.XML.user;


import com.example.productsshop.entities.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class UserXMLDto {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlElementWrapper(name = "sold-products")
    @XmlElement(name = "product")
    private List<ProductSoldDtoXml> products;

    public static UserXMLDto toUserXmlDto(User user){
        return new UserXMLDto(user.getFirstName(),
                user.getLastName(),
                user.getSoldProducts().stream().map(ProductSoldDtoXml::toProductSoldDtoXml).toList());
    }


}

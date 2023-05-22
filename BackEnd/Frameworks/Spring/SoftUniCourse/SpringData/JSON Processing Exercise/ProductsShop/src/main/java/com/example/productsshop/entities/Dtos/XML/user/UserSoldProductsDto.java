package com.example.productsshop.entities.Dtos.XML.user;

import com.example.productsshop.entities.Dtos.XML.product.ProductSimpleInfoDtoWrapper;
import com.example.productsshop.entities.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class UserSoldProductsDto {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute
    private Integer age;

    @XmlElement(name = "sold-products")
    ProductSimpleInfoDtoWrapper soldProducts;

    public static UserSoldProductsDto toUserSoldProductsDto(User user){
        return new UserSoldProductsDto(user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                ProductSimpleInfoDtoWrapper.toWrapper(user.getSoldProducts()));
    }

}

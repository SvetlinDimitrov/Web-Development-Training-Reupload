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
@XmlRootElement(name = "users")
public class UserSoldProductsDtoWrapper {
    @XmlAttribute
    private Integer count;

    @XmlElement(name = "user")
    private List<UserSoldProductsDto> users;

    public UserSoldProductsDtoWrapper(List<User> users){
        this.count = users.size();
        this.users = users.stream().map(UserSoldProductsDto::toUserSoldProductsDto).toList();
    }
}

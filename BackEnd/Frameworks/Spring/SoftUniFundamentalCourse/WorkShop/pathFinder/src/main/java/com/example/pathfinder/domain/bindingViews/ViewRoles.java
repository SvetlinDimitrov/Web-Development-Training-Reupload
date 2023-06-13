package com.example.pathfinder.domain.bindingViews;


import com.example.pathfinder.domain.constants.RoleConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewRoles  {

    private Long id;
    private RoleConstant role;

}

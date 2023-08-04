package com.example.pathfinder.domain.bindingViews;


import com.example.pathfinder.domain.constants.RoleConstant;
import com.example.pathfinder.domain.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewRoles  {

    private RoleConstant role;
    private Long Id;

    public ViewRoles(Role role) {
        this.role = role.getRole();
        this.Id = role.getId();
    }
}

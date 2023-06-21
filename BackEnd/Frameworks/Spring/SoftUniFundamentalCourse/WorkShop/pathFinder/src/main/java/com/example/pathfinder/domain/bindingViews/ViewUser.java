package com.example.pathfinder.domain.bindingViews;


import com.example.pathfinder.domain.constants.Level;
import com.example.pathfinder.domain.constants.RoleConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewUser  {

    private Long id;
    private String username;
    private String fullName;
    private Integer age;
    private String password;
    private String email;
    private Set<ViewRoles> roles = new HashSet<>();
    private Level level;
    private List<ViewComments> comments = new ArrayList<>();
    private List<ViewRoute> route = new ArrayList<>();
    private List<ViewPictures> pictures = new ArrayList<>();
    private List<ViewMessages> messages = new ArrayList<>();
    private List<ViewMessages> recipients = new ArrayList<>();

    public boolean isAdmin(){
        return roles.stream().map(ViewRoles::getRole).anyMatch(r->r.equals(RoleConstant.ADMIN));
    }

}

package com.example.pathfinder.domain.bindingViews;


import com.example.pathfinder.domain.constants.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Set<ViewRoles> roles;
    private Level level;
    private List<ViewComments> comments;
    private List<ViewRoute> route;
    private List<ViewPictures> pictures;
    private List<ViewMessages> messages;
    private List<ViewMessages> recipients;

}

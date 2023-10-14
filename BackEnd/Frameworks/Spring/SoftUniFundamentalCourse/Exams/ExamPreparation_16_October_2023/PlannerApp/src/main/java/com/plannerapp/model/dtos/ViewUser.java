package com.plannerapp.model.dtos;

import com.plannerapp.model.entity.UserEntity;
import com.plannerapp.model.entity.ViewTask;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ViewUser {


    private Long id;
    private String username;
    private String email;
    private List<ViewTask> assignedTasks;

    public ViewUser(UserEntity user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.assignedTasks = user.getAssignedTasks()
                .stream()
                .map(ViewTask::new)
                .collect(Collectors.toList());

    }
}

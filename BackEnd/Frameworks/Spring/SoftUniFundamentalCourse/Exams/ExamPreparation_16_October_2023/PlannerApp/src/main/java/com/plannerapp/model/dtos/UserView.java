package com.plannerapp.model.dtos;

import com.plannerapp.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserView {
    private Long id;
    private String username;
    private String password;
    private String email;
    private List<TaskView> assignedTasks;

    public UserView(User entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
        this.email = entity.getEmail();
        this.assignedTasks = entity.getAssignedTasks().stream().map(TaskView::new).collect(Collectors.toList());
    }
}

package com.plannerapp.model.entity;

import com.plannerapp.model.enums.PriorityConst;
import lombok.Data;

import java.text.SimpleDateFormat;

@Data
public class ViewTask {

    private Long id;
    private String description;
    private String dueData;
    private PriorityConst priority;

    public ViewTask(TaskEntity task) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        this.id = task.getId();
        this.description = task.getDescription();
        this.dueData = dateFormat.format(task.getDueData());
        this.priority = task.getPriority().getName();
    }
}

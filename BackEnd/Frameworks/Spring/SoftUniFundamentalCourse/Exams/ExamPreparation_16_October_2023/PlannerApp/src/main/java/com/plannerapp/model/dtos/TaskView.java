package com.plannerapp.model.dtos;
import com.plannerapp.model.entity.Task;
import com.plannerapp.model.enums.PriorityEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.text.SimpleDateFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskView {

    private Long id;
    private String description;
    private String dueData;
    private PriorityEnum priority;

    public TaskView(Task entity) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.id = entity.getId();
        this.description = entity.getDescription();
        this.dueData = dateFormat.format(entity.getDueData());
        this.priority = entity.getPriority().getName();
    }
}

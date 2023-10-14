package com.plannerapp.model.dtos;

import com.plannerapp.model.entity.TaskEntity;
import com.plannerapp.model.enums.PriorityConst;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class TaskAddDto {

    @NotBlank
    @Length(min = 2, max = 50)
    private String description;

    @NotNull
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    @NotNull
    private PriorityConst priority;

    public TaskEntity toTaskEntity (){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setDueData(dueDate);
        taskEntity.setDescription(description);
        return taskEntity;
    }

}

package com.plannerapp.service;

import com.plannerapp.model.dtos.TaskAddDto;
import com.plannerapp.model.entity.TaskEntity;
import com.plannerapp.model.entity.UserEntity;
import com.plannerapp.model.entity.ViewTask;
import com.plannerapp.repo.PriorityRepository;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.repo.UserRepository;
import lombok.Data;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final PriorityRepository priorityRepository;

    public void registerTask(TaskAddDto taskAddDto) {
        TaskEntity task = taskAddDto.toTaskEntity();

        task.setPriority(priorityRepository.findByName(taskAddDto.getPriority()).orElseThrow(() -> new IllegalArgumentException("no such priority found")));

        taskRepository.save(task);
    }

    @Transactional
    public List<ViewTask> getAllTaskExceptLoggedUserIdTasks(Long id) {

        List<Long> userTaskIds = userRepository.findById(id)
                .map(UserEntity::getAssignedTasks)
                .map(taskEntities -> taskEntities.stream().map(TaskEntity::getId).collect(Collectors.toList()))
                .orElseThrow();

        return taskRepository.findAll()
                .stream()
                .filter(task -> task.getUser() == null)
                .filter(task -> userTaskIds.stream().noneMatch(userTaskId -> userTaskId.equals(task.getId())))
                .map(ViewTask::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @Modifying
    public void assignTask(Long taskId, Long userId) {
        UserEntity user = getUserById(userId);
        TaskEntity taskEntity = getTaskById(taskId);

        taskEntity.setUser(user);
        taskRepository.save(taskEntity);

        user.getAssignedTasks().add(taskEntity);
        userRepository.save(user);
    }
    @Transactional
    @Modifying
    public void returnTask(Long taskId, Long userId) {
        UserEntity user = getUserById(userId);
        TaskEntity taskEntity = getTaskById(taskId);

        taskEntity.setUser(null);
        taskRepository.save(taskEntity);

        user.getAssignedTasks().remove(taskEntity);
        userRepository.save(user);
    }

    @Transactional
    @Modifying
    public void removeTask(Long taskId, Long userId) {
        UserEntity user = getUserById(userId);
        TaskEntity taskEntity = getTaskById(taskId);

        user.getAssignedTasks().remove(taskEntity);
        userRepository.save(user);

        taskRepository.delete(taskEntity);
    }

    private UserEntity getUserById(Long userId){
       return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("no user found with that id"));
    }
    private TaskEntity getTaskById(Long taskId){
        return taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("no task found with that id"));
    }


}

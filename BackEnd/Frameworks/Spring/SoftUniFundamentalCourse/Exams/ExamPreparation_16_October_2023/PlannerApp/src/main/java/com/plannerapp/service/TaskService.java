package com.plannerapp.service;

import com.plannerapp.model.dtos.TaskAddDto;
import com.plannerapp.model.dtos.TaskView;
import com.plannerapp.model.dtos.UserLogged;
import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.entity.Task;
import com.plannerapp.model.entity.User;
import com.plannerapp.repo.PriorityRepository;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final PriorityRepository priorityRepository;

    public void add(TaskAddDto taskAddDto) {
        Priority priority = priorityRepository.findByName(taskAddDto.getPriority()).orElseThrow(() -> new RuntimeException("No such priority exist"));
        taskRepository.save(toTask(taskAddDto , priority));
    }

    public Task toTask(TaskAddDto dto , Priority priority){
        Task task = new Task();
        task.setPriority(priority);
        task.setDueData(dto.getDueDate());
        task.setDescription(dto.getDescription());
        return task;
    }

    @Transactional
    public List<TaskView> getAllTaskWithoutLoggedUserTasks(UserLogged loggedUser) {
        User user  = userRepository.findByUsername(loggedUser.getUsername()).orElseThrow( () -> new RuntimeException("No suck user exist with username :" + loggedUser.getUsername()));
        return taskRepository.findAll()
                .stream()
                .filter(task -> task.getUser() == null)
                .map(TaskView::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void removeTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("no task exist with id :" + taskId));

        User user = task.getUser();
        user.getAssignedTasks().remove(task);
        userRepository.save(user);

        taskRepository.delete(task);
    }

    @Transactional
    public void returnTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("no task exist with id :" + taskId));

        User user = task.getUser();
        user.getAssignedTasks().remove(task);
        userRepository.save(user);

        task.setUser(null);
        taskRepository.save(task);
    }

    @Transactional
    public void assignTask(Long taskId, UserLogged loggedUser) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("no task exist with id :" + taskId));
        User user  = userRepository.findByUsername(loggedUser.getUsername()).orElseThrow( () -> new RuntimeException("No suck user exist with username :" + loggedUser.getUsername()));

        user.getAssignedTasks().add(task);
        userRepository.save(user);

        task.setUser(user);
        taskRepository.save(task);
    }
}

package org.hexagonal.infrastructure.adapter.out.mysql;

import lombok.RequiredArgsConstructor;
import org.hexagonal.core.domain.Todo;
import org.hexagonal.application.port.out.TodoDAO;
import org.hexagonal.infrastructure.adapter.out.mysql.entity.TodoEntity;
import org.hexagonal.infrastructure.adapter.out.mysql.repository.TodoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoMySqlDaoImp implements TodoDAO {

  private final TodoJpaRepository todoJpaRepository;

  @Override
  public List<Todo> findAll() {
    return todoJpaRepository.findAll()
        .stream()
        .map(this::mapToDomain)
        .toList();
  }

  @Override
  public Todo save(Todo todo) {
    TodoEntity toDoEntity = new TodoEntity();
    toDoEntity.setTitle(todo.title());
    toDoEntity.setDescription(todo.description());
    toDoEntity.setCompleted(todo.completed());
    return mapToDomain(todoJpaRepository.save(toDoEntity));
  }

  @Override
  public void deleteByTitle(String title) {
    todoJpaRepository.deleteByTitle(title);
  }

  @Override
  public Optional<Todo> findByTitle(String title) {
    return todoJpaRepository.findByTitle(title)
        .map(this::mapToDomain);
  }

  private Todo mapToDomain(TodoEntity toDoEntity) {
    return new Todo(toDoEntity.getTitle(), toDoEntity.getDescription() , toDoEntity.getCompleted());
  }
}

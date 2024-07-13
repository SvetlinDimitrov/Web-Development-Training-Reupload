package org.arch.clean.external.persistance;

import lombok.RequiredArgsConstructor;
import org.arch.clean.core.domain.model.TodoItem;
import org.arch.clean.core.domain.repository.TodoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TodoRepositoryImp implements TodoRepository {

  private final TodoJpaRepository springDataTodoRepository;

  @Override
  public List<TodoItem> findAll() {
    return springDataTodoRepository.findAll().stream()
        .map(this::mapToDomain)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<TodoItem> findById(Long id) {
    return springDataTodoRepository.findById(id).map(this::mapToDomain);
  }

  @Override
  public TodoItem save(TodoItem todoItem) {
    TodoEntity entity = mapToEntity(todoItem);
    TodoEntity savedEntity = springDataTodoRepository.save(entity);
    return mapToDomain(savedEntity);
  }

  @Override
  public void deleteById(Long id) {
    springDataTodoRepository.deleteById(id);
  }

  private TodoEntity mapToEntity(TodoItem todoItem) {
    TodoEntity entity = new TodoEntity();
    entity.setId(todoItem.id());
    entity.setDescription(todoItem.description());
    entity.setCompleted(todoItem.completed());
    return entity;
  }

  private TodoItem mapToDomain(TodoEntity entity) {
    return new TodoItem(
        entity.getId(),
        entity.getDescription(),
        entity.isCompleted()
    );
  }
}
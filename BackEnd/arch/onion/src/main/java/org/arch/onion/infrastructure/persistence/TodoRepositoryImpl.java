package org.arch.onion.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.arch.onion.domain.model.TodoItem;
import org.arch.onion.domain.repository.TodoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TodoRepositoryImpl implements TodoRepository {

  private final JpaTodoRepository jpaTodoRepository;

  @Override
  public TodoItem save(TodoItem todoItem) {
    TodoItemEntity entity = toEntity(todoItem);
    entity = jpaTodoRepository.save(entity);
    return toDomain(entity);
  }

  @Override
  public List<TodoItem> findAll() {
    return jpaTodoRepository.findAll().stream()
        .map(this::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<TodoItem> findById(Long id) {
    return jpaTodoRepository.findById(id)
        .map(this::toDomain);
  }

  @Override
  public void deleteById(Long id) {
    jpaTodoRepository.deleteById(id);
  }

  private TodoItemEntity toEntity(TodoItem todoItem) {
    TodoItemEntity entity = new TodoItemEntity();
    entity.setId(todoItem.id());
    entity.setTitle(todoItem.title());
    entity.setDescription(todoItem.description());
    entity.setCompleted(todoItem.completed());
    entity.setCreatedAt(todoItem.createdAt());
    entity.setUpdatedAt(todoItem.updatedAt());
    return entity;
  }

  private TodoItem toDomain(TodoItemEntity entity) {
    return new TodoItem(
        entity.getId(),
        entity.getTitle(),
        entity.getDescription(),
        entity.isCompleted(),
        entity.getCreatedAt(),
        entity.getUpdatedAt()
    );
  }
}

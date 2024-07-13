package org.arch.clean.core.domain.repository;

import org.arch.clean.core.domain.model.TodoItem;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
  List<TodoItem> findAll();

  Optional<TodoItem> findById(Long id);

  TodoItem save(TodoItem todoItem);

  void deleteById(Long id);
}

package org.arch.onion.domain.repository;

import org.arch.onion.domain.model.TodoItem;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
  TodoItem save(TodoItem todoItem);

  List<TodoItem> findAll();

  Optional<TodoItem> findById(Long id);

  void deleteById(Long id);
}

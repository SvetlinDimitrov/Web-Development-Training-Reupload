package org.hexagonal.application.port.input;

import org.hexagonal.core.domain.Todo;

import java.util.List;


public interface TodoUseCase {

  List<Todo> getAllTodos();

  Todo getTodoByTitle(String title);

  Todo createOrUpdateTodo(Todo todo);

  void deleteByTitle(String title);
}

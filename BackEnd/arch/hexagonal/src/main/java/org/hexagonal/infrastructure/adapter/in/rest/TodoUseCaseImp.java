package org.hexagonal.infrastructure.adapter.in.rest;

import lombok.RequiredArgsConstructor;
import org.hexagonal.application.port.in.TodoUseCase;
import org.hexagonal.application.port.out.TodoDAO;
import org.hexagonal.core.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoUseCaseImp implements TodoUseCase {

  private final TodoDAO todoDAO;

  @Override
  public List<Todo> getAllTodos() {
    return todoDAO.findAll();
  }

  @Override
  public Todo getTodoByTitle(String title) {
    return todoDAO.findByTitle(title).orElseThrow();
  }

  @Override
  public Todo createOrUpdateTodo(Todo todo) {
    return todoDAO.save(todo);
  }

  @Override
  public void deleteByTitle(String title) {
    todoDAO.deleteByTitle(title);
  }
}

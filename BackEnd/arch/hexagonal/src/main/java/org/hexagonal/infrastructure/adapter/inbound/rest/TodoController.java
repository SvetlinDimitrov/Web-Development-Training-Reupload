package org.hexagonal.infrastructure.adapter.inbound.rest;

import lombok.RequiredArgsConstructor;
import org.hexagonal.application.port.input.CreateOrUpdateTodoUseCase;
import org.hexagonal.application.port.input.DeleteByTitleUseCase;
import org.hexagonal.application.port.input.GetAllTodosUseCase;
import org.hexagonal.application.port.input.GetTodoByTitleUseCase;
import org.hexagonal.core.domain.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

  private final CreateOrUpdateTodoUseCase createOrUpdateTodo;
  private final GetTodoByTitleUseCase getTodoByTitle;
  private final GetAllTodosUseCase getAllTodos;
  private final DeleteByTitleUseCase deleteTodoByTitle;

  @GetMapping
  public List<Todo> getAllTodos() {
    return getAllTodos.execute();
  }

  @GetMapping("/{title}")
  public Todo getTodoByTitle(@PathVariable String title) {
    return getTodoByTitle.execute(title);
  }

  @PostMapping
  public Todo createOrUpdateTodo(@RequestBody Todo todo) {
    return createOrUpdateTodo.execute(todo);
  }

  @DeleteMapping("/{title}")
  public void deleteTodoById(@PathVariable String title) {
    deleteTodoByTitle.execute(title);
  }
}

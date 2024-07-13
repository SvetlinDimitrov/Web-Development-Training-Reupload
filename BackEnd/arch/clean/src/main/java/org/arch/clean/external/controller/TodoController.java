package org.arch.clean.external.controller;

import lombok.RequiredArgsConstructor;
import org.arch.clean.core.application.CreateTodoUseCase;
import org.arch.clean.core.application.DeleteTodoUseCase;
import org.arch.clean.core.application.GetTodoByIdUseCase;
import org.arch.clean.core.application.GetTodosUseCase;
import org.arch.clean.core.domain.model.TodoItem;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

  private final CreateTodoUseCase createTodoUseCase;
  private final GetTodosUseCase getTodosUseCase;
  private final GetTodoByIdUseCase getTodoByIdUseCase;
  private final DeleteTodoUseCase deleteTodoUseCase;

  @GetMapping
  public List<TodoItem> findAll() {
    return getTodosUseCase.execute();
  }

  @GetMapping("/{id}")
  public TodoItem findById(@PathVariable Long id) {
    return getTodoByIdUseCase.execute(id);
  }

  @PostMapping
  public TodoItem save(@RequestBody TodoItem todoItemDTO) {
    return createTodoUseCase.execute(todoItemDTO);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    deleteTodoUseCase.execute(id);
  }
}

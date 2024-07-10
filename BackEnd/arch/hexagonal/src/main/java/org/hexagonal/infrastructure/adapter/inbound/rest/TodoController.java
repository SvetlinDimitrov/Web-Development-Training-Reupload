package org.hexagonal.infrastructure.adapter.inbound.rest;

import org.hexagonal.application.port.input.TodoUseCase;
import org.hexagonal.core.domain.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

  private final TodoUseCase todoService;

  public TodoController(TodoUseCase todoService) {
    this.todoService = todoService;
  }

  @GetMapping
  public List<Todo> getAllTodos() {
    return todoService.getAllTodos();
  }

  @GetMapping("/{title}")
  public Todo getTodoByTitle(@PathVariable String title) {
    return todoService.getTodoByTitle(title);
  }

  @PostMapping
  public Todo createOrUpdateTodo(@RequestBody Todo todo) {
    return todoService.createOrUpdateTodo(todo);
  }

  @DeleteMapping("/{title}")
  public void deleteTodoById(@PathVariable String title) {
    todoService.deleteByTitle(title);
  }
}

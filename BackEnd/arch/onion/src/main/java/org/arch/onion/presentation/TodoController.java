package org.arch.onion.presentation;

import lombok.RequiredArgsConstructor;
import org.arch.onion.application.TodoUseCase;
import org.arch.onion.domain.model.TodoItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

  private final TodoUseCase todoUseCase;

  @PostMapping
  public ResponseEntity<TodoItem> createTodoItem(@RequestBody TodoItem todoItem) {
    TodoItem createdTodoItem = todoUseCase.createTodoItem(todoItem);
    return ResponseEntity.ok(createdTodoItem);
  }

  @GetMapping
  public ResponseEntity<List<TodoItem>> getAllTodoItems() {
    List<TodoItem> todoItems = todoUseCase.getAllTodoItems();
    return ResponseEntity.ok(todoItems);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TodoItem> getTodoItemById(@PathVariable Long id) {
    return todoUseCase.getTodoItemById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTodoItem(@PathVariable Long id) {
    todoUseCase.deleteTodoItem(id);
    return ResponseEntity.noContent().build();
  }
}

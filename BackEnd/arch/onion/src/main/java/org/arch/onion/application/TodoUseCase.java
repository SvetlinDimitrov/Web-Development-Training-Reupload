package org.arch.onion.application;

import lombok.RequiredArgsConstructor;
import org.arch.onion.domain.model.TodoItem;
import org.arch.onion.domain.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoUseCase {

  private final TodoRepository todoRepository;

  public TodoItem createTodoItem(TodoItem todoItem) {
    return todoRepository.save(todoItem);
  }

  public List<TodoItem> getAllTodoItems() {
    return todoRepository.findAll();
  }

  public Optional<TodoItem> getTodoItemById(Long id) {
    return todoRepository.findById(id);
  }

  public void deleteTodoItem(Long id) {
    todoRepository.deleteById(id);
  }
}
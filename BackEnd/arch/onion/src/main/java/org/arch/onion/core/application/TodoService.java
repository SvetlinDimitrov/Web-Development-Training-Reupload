package org.arch.onion.core.application;

import lombok.RequiredArgsConstructor;
import org.arch.onion.core.domain.model.TodoItem;
import org.arch.onion.core.domain.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

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
package org.arch.clean.core.application;

import lombok.RequiredArgsConstructor;
import org.arch.clean.core.domain.model.TodoItem;
import org.arch.clean.core.domain.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTodoUseCase {

  private final TodoRepository todoRepository;

  public TodoItem execute(TodoItem todoItem) {
    return todoRepository.save(todoItem);
  }
}

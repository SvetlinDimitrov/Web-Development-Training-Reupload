package org.arch.clean.core.application;

import lombok.RequiredArgsConstructor;
import org.arch.clean.core.domain.model.TodoItem;
import org.arch.clean.core.domain.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTodosUseCase {

  private final TodoRepository todoRepository;

  public List<TodoItem> execute() {
    return todoRepository.findAll();
  }
}

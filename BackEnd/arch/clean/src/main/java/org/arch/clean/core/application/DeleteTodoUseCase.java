package org.arch.clean.core.application;

import lombok.RequiredArgsConstructor;
import org.arch.clean.core.domain.repository.TodoRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteTodoUseCase {

  private final TodoRepository todoRepository;

  public void execute(Long id) {
    todoRepository.deleteById(id);
  }
}

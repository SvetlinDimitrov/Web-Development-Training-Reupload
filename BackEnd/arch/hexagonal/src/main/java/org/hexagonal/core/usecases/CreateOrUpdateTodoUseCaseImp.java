package org.hexagonal.core.usecases;

import lombok.RequiredArgsConstructor;
import org.hexagonal.application.port.input.CreateOrUpdateTodoUseCase;
import org.hexagonal.application.port.output.TodoDAO;
import org.hexagonal.core.domain.Todo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateOrUpdateTodoUseCaseImp implements CreateOrUpdateTodoUseCase {

  private final TodoDAO todoDAO;

  @Override
  public Todo execute(Todo todo) {
    return todoDAO.save(todo);
  }
}

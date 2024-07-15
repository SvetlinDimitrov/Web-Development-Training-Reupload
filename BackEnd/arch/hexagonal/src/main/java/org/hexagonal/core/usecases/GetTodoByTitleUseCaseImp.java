package org.hexagonal.core.usecases;

import lombok.RequiredArgsConstructor;
import org.hexagonal.application.port.input.GetTodoByTitleUseCase;
import org.hexagonal.application.port.output.TodoDAO;
import org.hexagonal.core.domain.Todo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTodoByTitleUseCaseImp implements GetTodoByTitleUseCase {

  private final TodoDAO todoDAO;

  @Override
  public Todo execute(String title) {
    return todoDAO.findByTitle(title).orElseThrow();
  }
}

package org.hexagonal.core.usecases;

import lombok.RequiredArgsConstructor;
import org.hexagonal.application.port.input.GetAllTodosUseCase;
import org.hexagonal.application.port.output.TodoDAO;
import org.hexagonal.core.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllTodosUseCaseImp implements GetAllTodosUseCase {

  private final TodoDAO todoDAO;

  @Override
  public List<Todo> execute() {
    return todoDAO.findAll();
  }
}

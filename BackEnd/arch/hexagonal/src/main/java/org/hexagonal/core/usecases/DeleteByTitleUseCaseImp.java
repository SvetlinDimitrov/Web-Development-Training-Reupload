package org.hexagonal.core.usecases;

import lombok.RequiredArgsConstructor;
import org.hexagonal.application.port.input.DeleteByTitleUseCase;
import org.hexagonal.application.port.output.TodoDAO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteByTitleUseCaseImp implements DeleteByTitleUseCase {

  private final TodoDAO todoDAO;

  @Override
  public void execute(String title) {
    todoDAO.deleteByTitle(title);
  }
}

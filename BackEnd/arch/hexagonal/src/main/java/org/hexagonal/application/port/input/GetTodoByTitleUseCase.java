package org.hexagonal.application.port.input;

import org.hexagonal.core.domain.Todo;

public interface GetTodoByTitleUseCase {

  Todo execute(String title);

}

package org.hexagonal.application.port.input;

import org.hexagonal.core.domain.Todo;

public interface CreateOrUpdateTodoUseCase {

  Todo execute(Todo todo);

}

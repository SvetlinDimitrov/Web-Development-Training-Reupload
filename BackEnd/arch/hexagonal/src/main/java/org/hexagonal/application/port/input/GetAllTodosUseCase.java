package org.hexagonal.application.port.input;

import org.hexagonal.core.domain.Todo;

import java.util.List;

public interface GetAllTodosUseCase {

  List<Todo> execute();

}

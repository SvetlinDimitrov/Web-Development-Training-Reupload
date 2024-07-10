package org.hexagonal.application.port.out;

import org.hexagonal.core.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoDAO {
  List<Todo> findAll();

  Todo save(Todo todo);

  void deleteByTitle(String title);

  Optional<Todo> findByTitle(String title);
}

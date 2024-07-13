package org.arch.onion.external.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTodoRepository extends JpaRepository<TodoItemEntity, Long> {
}

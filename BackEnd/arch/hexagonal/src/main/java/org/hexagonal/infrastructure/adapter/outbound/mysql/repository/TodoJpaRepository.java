package org.hexagonal.infrastructure.adapter.outbound.mysql.repository;

import org.hexagonal.infrastructure.adapter.outbound.mysql.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoJpaRepository extends JpaRepository<TodoEntity, Long> {

  void deleteByTitle(String title);

  Optional<TodoEntity> findByTitle(String title);
}

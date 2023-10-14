package com.plannerapp.repo;

import com.plannerapp.model.entity.PriorityEntity;
import com.plannerapp.model.enums.PriorityConst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriorityRepository extends JpaRepository<PriorityEntity , Long> {
    Optional<PriorityEntity> findByName(PriorityConst priorityConst);
}


package org.arch.onion.core.domain.model;

import java.time.LocalDateTime;

public record TodoItem(
    Long id,
    String title,
    String description,
    boolean completed,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {

}

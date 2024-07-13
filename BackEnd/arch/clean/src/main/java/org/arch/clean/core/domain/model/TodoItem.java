package org.arch.clean.core.domain.model;

public record TodoItem(
    Long id,
    String description,
    Boolean completed
) {
}

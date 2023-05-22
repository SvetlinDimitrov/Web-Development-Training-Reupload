package org.example;

import javax.persistence.*;

@MappedSuperclass
public abstract class IdExtender {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

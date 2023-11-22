package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
public abstract class AuditEntity<T extends Serializable> implements BaseEntity<T>{

    private Instant createdAt;

    private String createdBy;
}

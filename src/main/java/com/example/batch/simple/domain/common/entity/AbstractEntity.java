package com.example.batch.simple.domain.common.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import java.time.ZonedDateTime;

@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {

    @CreationTimestamp
    protected ZonedDateTime createAt;

    @UpdateTimestamp
    protected ZonedDateTime updatedAt;
}

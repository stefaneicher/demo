package com.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Version;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class VersionedBaseEntity implements Serializable {

    @Column(name = "creation_time", nullable = false)
    private LocalDateTime creationTime;

    @Column(name = "modification_time", nullable = false)
    private LocalDateTime modificationTime;

    @SuppressWarnings("unused")
    @Version
    private Long version;

    @PrePersist
    public final void prePersist() {
        var now = LocalDateTime.now();
        creationTime = now;
        modificationTime = now;
    }
}
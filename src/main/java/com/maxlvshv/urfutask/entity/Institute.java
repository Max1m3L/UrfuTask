package com.maxlvshv.urfutask.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

/**
 * Сущность Institute, представляющая институты в системе.
 * Эта сущность содержит информацию о названии института, включая его уникальный идентификатор.
 *
 */
@Entity
public class Institute {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(nullable = false)
    private String title;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

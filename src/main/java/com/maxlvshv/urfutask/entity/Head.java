package com.maxlvshv.urfutask.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

/**
 * Сущность Head, представляющая ответственные лица в системе.
 * Эта сущность содержит информацию о имени, включая его уникальный идентификатор.
 *
 */
@Entity
public class Head {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(nullable = false)
    private String fullname;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}

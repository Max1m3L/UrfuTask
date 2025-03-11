package com.maxlvshv.urfutask.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Module {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ModuleTypeEnum type;

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

    public ModuleTypeEnum getType() {
        return type;
    }

    public void setType(ModuleTypeEnum type) {
        this.type = type;
    }
}

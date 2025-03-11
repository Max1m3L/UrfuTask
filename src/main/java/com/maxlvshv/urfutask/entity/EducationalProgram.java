package com.maxlvshv.urfutask.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class EducationalProgram {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String cypher;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LevelEnum level;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StandardEnum standard;

    @ManyToOne
    @JoinColumn(name = "institute_id", nullable = false)
    private Institute institute;

    @ManyToOne
    @JoinColumn(name = "head_id", nullable = false)
    private Head head;

    @Column(nullable = false)
    private LocalDate accreditationDate;

    @ManyToMany
    @JoinTable(
            name = "program_modules",
            joinColumns = @JoinColumn(name = "program_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private List<Module> modules;

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

    public String getCypher() {
        return cypher;
    }

    public void setCypher(String cypher) {
        this.cypher = cypher;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public StandardEnum getStandard() {
        return standard;
    }

    public void setStandard(StandardEnum standard) {
        this.standard = standard;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public LocalDate getAccreditationDate() {
        return accreditationDate;
    }

    public void setAccreditationDate(LocalDate accreditationDate) {
        this.accreditationDate = accreditationDate;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}

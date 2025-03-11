package com.maxlvshv.urfutask.controller;

import com.maxlvshv.urfutask.entity.EducationalProgram;
import com.maxlvshv.urfutask.service.EducationalProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/program")
public class EducationalProgramController {
    private final EducationalProgramService programService;

    @Autowired
    public EducationalProgramController(EducationalProgramService programService) {
        this.programService = programService;
    }

    @PostMapping
    public ResponseEntity<EducationalProgram> createProgram(@RequestBody EducationalProgram program) {
        EducationalProgram createdProgram = programService.createProgram(program);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProgram);
    }

    @GetMapping
    public ResponseEntity<List<EducationalProgram>> getAllPrograms() {
        return ResponseEntity.ok(programService.getAllPrograms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationalProgram> getProgram(@PathVariable UUID id) {
        EducationalProgram program = programService.getProgram(id);
        return program != null ? ResponseEntity.ok(program) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducationalProgram> updateProgram(@PathVariable UUID id, @RequestBody EducationalProgram program) {
        program.setUuid(id);
        EducationalProgram updatedProgram = programService.updateProgram(program);
        return ResponseEntity.ok(updatedProgram);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgram(@PathVariable UUID id) {
        programService.deleteProgram(id);
        return ResponseEntity.noContent().build();
    }
}

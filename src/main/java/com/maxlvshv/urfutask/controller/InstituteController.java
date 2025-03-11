package com.maxlvshv.urfutask.controller;

import com.maxlvshv.urfutask.entity.Institute;
import com.maxlvshv.urfutask.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/institute")
public class InstituteController {
    private final InstituteService instituteService;
    
    @Autowired
    public InstituteController(InstituteService instituteService) {
        this.instituteService = instituteService;
    }

    @PostMapping
    public ResponseEntity<Institute> createProgram(@RequestBody Institute institute) {
        Institute createdInstitute = instituteService.createInstitute(institute);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInstitute);
    }

    @GetMapping
    public ResponseEntity<List<Institute>> getInstitutes() {
        return ResponseEntity.ok(instituteService.getAllInstitutes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Institute> updateInstitute(@PathVariable UUID id, @RequestBody Institute institute) {
        institute.setUuid(id);
        Institute updatedInstitute = instituteService.updateInstitute(institute);
        return ResponseEntity.ok(updatedInstitute);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitute(@PathVariable UUID id) {
        instituteService.deleteInstitute(id);
        return ResponseEntity.noContent().build();
    }
}

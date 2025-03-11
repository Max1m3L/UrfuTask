package com.maxlvshv.urfutask.controller;

import com.maxlvshv.urfutask.entity.Module;
import com.maxlvshv.urfutask.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/module")
public class ModuleController {
    private final ModuleService moduleService;
    
    @Autowired
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @PostMapping
    public ResponseEntity<Module> createProgram(@RequestBody Module module) {
        Module createdModule = moduleService.createModule(module);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdModule);
    }

    @GetMapping
    public ResponseEntity<List<Module>> getModules() {
        return ResponseEntity.ok(moduleService.getAllModules());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable UUID id, @RequestBody Module module) {
        module.setUuid(id);
        Module updatedModule = moduleService.updateModule(module);
        return ResponseEntity.ok(updatedModule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable UUID id) {
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }
}

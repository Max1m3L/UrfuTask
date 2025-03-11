package com.maxlvshv.urfutask.controller;

import com.maxlvshv.urfutask.entity.Head;
import com.maxlvshv.urfutask.service.HeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/head")
public class HeadController {
    private final HeadService headService;

    @Autowired
    public HeadController(HeadService headService) {
        this.headService = headService;
    }

    @PostMapping
    public ResponseEntity<Head> createProgram(@RequestBody Head head) {
        Head createdHead = headService.createHead(head);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHead);
    }

    @GetMapping
    public ResponseEntity<List<Head>> getHeads() {
        return ResponseEntity.ok(headService.getAllHeads());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Head> updateHead(@PathVariable UUID id, @RequestBody Head head) {
        head.setUuid(id);
        Head updatedHead = headService.updateHead(head);
        return ResponseEntity.ok(updatedHead);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHead(@PathVariable UUID id) {
        headService.deleteHead(id);
        return ResponseEntity.noContent().build();
    }
}

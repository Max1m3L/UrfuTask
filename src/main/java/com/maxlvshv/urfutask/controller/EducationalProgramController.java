package com.maxlvshv.urfutask.controller;

import com.maxlvshv.urfutask.entity.EducationalProgram;
import com.maxlvshv.urfutask.service.EducationalProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Контроллер для управления сущностями EducationalProgram.
 * Обрабатывает HTTP-запросы, связанные с сущностями EducationalProgram,
 * включая создание, обновление, удаление и получение информации о них.
 */
@RestController
@RequestMapping("/api/program")
public class EducationalProgramController {
    private final EducationalProgramService programService;

    @Autowired
    public EducationalProgramController(EducationalProgramService programService) {
        this.programService = programService;
    }

    /**
     * Создает новую сущность EducationalProgram.
     *
     * @param program объект EducationalProgram, который нужно создать
     * @return ResponseEntity с созданным объектом EducationalProgram
     */
    @PostMapping
    public ResponseEntity<EducationalProgram> createProgram(@RequestBody EducationalProgram program) {
        EducationalProgram createdProgram = programService.createProgram(program);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProgram);
    }

    /**
     * Возвращает все существующие объекты EducationalProgram.
     *
     * @return List<EducationalProgram>
     */
    @GetMapping
    public ResponseEntity<List<EducationalProgram>> getAllPrograms() {
        return ResponseEntity.ok(programService.getAllPrograms());
    }

    /**
     * Получает сущность EducationalProgram по идентификатору.
     *
     * @param id идентификатор сущности EducationalProgram
     * @return ResponseEntity с найденным объектом EducationalProgram или статусом 404, если не найден
     */
    @GetMapping("/{id}")
    public ResponseEntity<EducationalProgram> getProgram(@PathVariable UUID id) {
        EducationalProgram program = programService.getProgram(id);
        return program != null ? ResponseEntity.ok(program) : ResponseEntity.notFound().build();
    }

    /**
     * Обновляет существующую сущность EducationalProgram.
     *
     * @param program объект EducationalProgram с обновленными данными
     * @return ResponseEntity с обновленным объектом EducationalProgram
     */
    @PutMapping("/{id}")
    public ResponseEntity<EducationalProgram> updateProgram(@PathVariable UUID id, @RequestBody EducationalProgram program) {
        program.setUuid(id);
        EducationalProgram updatedProgram = programService.updateProgram(program);
        return ResponseEntity.ok(updatedProgram);
    }

    /**
     * Удаляет сущность EducationalProgram по идентификатору.
     *
     * @param id идентификатор сущности EducationalProgram, которую нужно удалить
     * @return ResponseEntity с статусом выполнения операции
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgram(@PathVariable UUID id) {
        programService.deleteProgram(id);
        return ResponseEntity.noContent().build();
    }
}

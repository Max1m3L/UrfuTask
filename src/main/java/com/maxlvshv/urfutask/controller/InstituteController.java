package com.maxlvshv.urfutask.controller;

import com.maxlvshv.urfutask.entity.Institute;
import com.maxlvshv.urfutask.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Контроллер для управления сущностями Institute.
 * Обрабатывает HTTP-запросы, связанные с сущностями Institute,
 * включая создание, обновление, удаление и получение информации о них.
 */
@RestController
@RequestMapping("/api/institute")
public class InstituteController {
    private final InstituteService instituteService;
    
    @Autowired
    public InstituteController(InstituteService instituteService) {
        this.instituteService = instituteService;
    }

    /**
     * Создает новую сущность Institute.
     *
     * @param institute объект Institute, который нужно создать
     * @return ResponseEntity с созданным объектом Institute
     */
    @PostMapping
    public ResponseEntity<Institute> createProgram(@RequestBody Institute institute) {
        Institute createdInstitute = instituteService.createInstitute(institute);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInstitute);
    }

    /**
     * Возвращает все существующие объекты Institute.
     *
     * @return List<Institute>
     */
    @GetMapping
    public ResponseEntity<List<Institute>> getInstitutes() {
        return ResponseEntity.ok(instituteService.getAllInstitutes());
    }

    /**
     * Обновляет существующую сущность Institute.
     *
     * @param institute объект Institute с обновленными данными
     * @return ResponseEntity с обновленным объектом Institute
     */
    @PutMapping("/{id}")
    public ResponseEntity<Institute> updateInstitute(@PathVariable UUID id, @RequestBody Institute institute) {
        institute.setUuid(id);
        Institute updatedInstitute = instituteService.updateInstitute(institute);
        return ResponseEntity.ok(updatedInstitute);
    }

    /**
     * Удаляет сущность Institute по идентификатору.
     *
     * @param id идентификатор сущности Institute, которую нужно удалить
     * @return ResponseEntity с статусом выполнения операции
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitute(@PathVariable UUID id) {
        instituteService.deleteInstitute(id);
        return ResponseEntity.noContent().build();
    }
}

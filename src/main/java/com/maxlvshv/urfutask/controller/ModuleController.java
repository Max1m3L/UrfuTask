package com.maxlvshv.urfutask.controller;

import com.maxlvshv.urfutask.entity.Module;
import com.maxlvshv.urfutask.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Контроллер для управления сущностями Module.
 * Обрабатывает HTTP-запросы, связанные с сущностями Module,
 * включая создание, обновление, удаление и получение информации о них.
 */
@RestController
@RequestMapping("/api/module")
public class ModuleController {
    private final ModuleService moduleService;
    
    @Autowired
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    /**
     * Создает новую сущность Module.
     *
     * @param module объект Module, который нужно создать
     * @return ResponseEntity с созданным объектом Module
     */
    @PostMapping
    public ResponseEntity<Module> createProgram(@RequestBody Module module) {
        Module createdModule = moduleService.createModule(module);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdModule);
    }

    /**
     * Возвращает все существующие объекты Module.
     *
     * @return List<Module>
     */
    @GetMapping
    public ResponseEntity<List<Module>> getModules() {
        return ResponseEntity.ok(moduleService.getAllModules());
    }

    /**
     * Обновляет существующую сущность Module.
     *
     * @param module объект Module с обновленными данными
     * @return ResponseEntity с обновленным объектом Module
     */
    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable UUID id, @RequestBody Module module) {
        module.setUuid(id);
        Module updatedModule = moduleService.updateModule(module);
        return ResponseEntity.ok(updatedModule);
    }

    /**
     * Удаляет сущность Module по идентификатору.
     *
     * @param id идентификатор сущности Module, которую нужно удалить
     * @return ResponseEntity с статусом выполнения операции
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable UUID id) {
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }
}

package com.maxlvshv.urfutask.controller;

import com.maxlvshv.urfutask.entity.Head;
import com.maxlvshv.urfutask.service.HeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Контроллер для управления сущностями Head.
 * Обрабатывает HTTP-запросы, связанные с сущностями Head,
 * включая создание, обновление, удаление и получение информации о них.
 */
@RestController
@RequestMapping("/api/head")
public class HeadController {
    private final HeadService headService;

    @Autowired
    public HeadController(HeadService headService) {
        this.headService = headService;
    }

    /**
     * Создает новую сущность Head.
     *
     * @param head объект Head, который нужно создать
     * @return ResponseEntity с созданным объектом Head
     */
    @PostMapping
    public ResponseEntity<Head> createProgram(@RequestBody Head head) {
        Head createdHead = headService.createHead(head);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHead);
    }

    /**
     * Возвращает все существующие объекты Head.
     *
     * @return List<Head>
     */
    @GetMapping
    public ResponseEntity<List<Head>> getHeads() {
        return ResponseEntity.ok(headService.getAllHeads());
    }

    /**
     * Обновляет существующую сущность Head.
     *
     * @param head объект Head с обновленными данными
     * @return ResponseEntity с обновленным объектом Head
     */
    @PutMapping("/{id}")
    public ResponseEntity<Head> updateHead(@PathVariable UUID id, @RequestBody Head head) {
        head.setUuid(id);
        Head updatedHead = headService.updateHead(head);
        return ResponseEntity.ok(updatedHead);
    }

    /**
     * Удаляет сущность Head по идентификатору.
     *
     * @param id идентификатор сущности Head, которую нужно удалить
     * @return ResponseEntity с статусом выполнения операции
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHead(@PathVariable UUID id) {
        headService.deleteHead(id);
        return ResponseEntity.noContent().build();
    }
}

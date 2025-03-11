package com.maxlvshv.urfutask.service;

import com.maxlvshv.urfutask.entity.EducationalProgram;
import com.maxlvshv.urfutask.repository.EducationalProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Сервис предоставляет методы для создания, обновления и удаления сущности EducationalProgram.
 * Взаимодействует с репозиторием (EducationalProgramRepository) для выполнения операций с базой данных
 *
 */
@Service
public class EducationalProgramService {
    private final EducationalProgramRepository repository;

    @Autowired
    public EducationalProgramService(EducationalProgramRepository repository) {
        this.repository = repository;
    }

    /**
     * Создаёт объект EducationalProgram
     * @param program
     * @return созданный EducationalProgram
     */
    public EducationalProgram createProgram(EducationalProgram program) {
        return repository.save(program);
    }

    /**
     * Возвращает весь список EducationalProgram из БД
     * @return List<EducationalProgram>
     */
    public List<EducationalProgram> getAllPrograms() {
        return repository.findAll();
    }

    /**
     * Возвращает существующую сущность educationalProgram по id
     * @param uuid
     * @return educationalProgram
     */
    public EducationalProgram getProgram(UUID uuid) {
        return repository.findById(uuid).orElse(null);
    }

    /**
     * Обновляет существующую сущность EducationalProgram
     * @param program
     * @return обновлённый educationalProgram
     */
    public EducationalProgram updateProgram(EducationalProgram program) {
        return repository.save(program);
    }

    /**
     * Удаляет существующую сущность educationalProgram по id
     * @param uuid
     */
    public void deleteProgram(UUID uuid) {
        repository.deleteById(uuid);
    }
}

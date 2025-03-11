package com.maxlvshv.urfutask.service;

import com.maxlvshv.urfutask.entity.Module;
import com.maxlvshv.urfutask.exception.EntityAlreadyExistsException;
import com.maxlvshv.urfutask.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Сервис предоставляет методы для создания, обновления и удаления сущности Module.
 * Взаимодействует с репозиторием (ModuleRepository) для выполнения операций с базой данных
 *
 */
@Service
public class ModuleService {
    private final ModuleRepository moduleRepository;
    
    @Autowired
    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    /**
     * Создаёт объект Module
     * @param module
     * @return созданный module
     */
    public Module createModule(Module module) {
        if (moduleRepository.existsByTitle(module.getTitle())) {
            throw new EntityAlreadyExistsException("Module with title '" + module.getTitle() + "' already exists.");
        }
        return moduleRepository.save(module);
    }

    /**
     * Возвращает весь список module из БД
     * @return List<Module>
     */
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    /**
     * Обновляет существующую сущность Module
     * @param module
     * @return обновлённый module
     */
    public Module updateModule(Module module) {
        return moduleRepository.save(module);
    }

    /**
     * Удаляет существующую сущность module по id
     * @param uuid
     */
    public void deleteModule(UUID uuid) {
        moduleRepository.deleteById(uuid);
    }
}

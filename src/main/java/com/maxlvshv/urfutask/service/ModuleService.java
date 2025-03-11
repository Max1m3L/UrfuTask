package com.maxlvshv.urfutask.service;

import com.maxlvshv.urfutask.entity.Module;
import com.maxlvshv.urfutask.exception.EntityAlreadyExistsException;
import com.maxlvshv.urfutask.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ModuleService {
    private final ModuleRepository moduleRepository;
    
    @Autowired
    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public Module createModule(Module module) {
        if (moduleRepository.existsByTitle(module.getTitle())) {
            throw new EntityAlreadyExistsException("Module with title '" + module.getTitle() + "' already exists.");
        }
        return moduleRepository.save(module);
    }

    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    public Module updateModule(Module module) {
        return moduleRepository.save(module);
    }

    public void deleteModule(UUID uuid) {
        moduleRepository.deleteById(uuid);
    }
}

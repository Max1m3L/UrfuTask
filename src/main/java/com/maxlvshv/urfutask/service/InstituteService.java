package com.maxlvshv.urfutask.service;

import com.maxlvshv.urfutask.entity.Institute;
import com.maxlvshv.urfutask.exception.EntityAlreadyExistsException;
import com.maxlvshv.urfutask.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Сервис предоставляет методы для создания, обновления и удаления сущности Institute.
 * Взаимодействует с репозиторием (InstituteRepository) для выполнения операций с базой данных
 *
 */
@Service
public class InstituteService {
    private final InstituteRepository instituteRepository;

    @Autowired
    public InstituteService(InstituteRepository instituteRepository) {
        this.instituteRepository = instituteRepository;
    }

    /**
     * Создаёт объект Institute
     * @param institute
     * @return созданный institute
     */
    public Institute createInstitute(Institute institute) {
        if (instituteRepository.existsByTitle(institute.getTitle())) {
            throw new EntityAlreadyExistsException("Institute with title '" + institute.getTitle() + "' already exists.");
        }
        return instituteRepository.save(institute);
    }

    /**
     * Возвращает весь список institute из БД
     * @return List<Institute>
     */
    public List<Institute> getAllInstitutes() {
        return instituteRepository.findAll();
    }

    /**
     * Обновляет существующую сущность Institute
     * @param institute
     * @return обновлённый institute
     */
    public Institute updateInstitute(Institute institute) {
        return instituteRepository.save(institute);
    }

    /**
     * Удаляет существующую сущность institute по id
     * @param uuid
     */
    public void deleteInstitute(UUID uuid) {
        instituteRepository.deleteById(uuid);
    }
}

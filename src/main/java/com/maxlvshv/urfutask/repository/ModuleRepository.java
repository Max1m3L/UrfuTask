package com.maxlvshv.urfutask.repository;

import com.maxlvshv.urfutask.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Репозиторий для работы с сущностями Module.
 * Предоставляет методы для выполнения операций CRUD
 *  (создание, чтение, обновление, удаление) с сущностями Module.
 */
@Repository
public interface ModuleRepository extends JpaRepository<Module, UUID> {
    boolean existsByTitle(String title);
}

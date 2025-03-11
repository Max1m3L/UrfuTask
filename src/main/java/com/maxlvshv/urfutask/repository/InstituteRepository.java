package com.maxlvshv.urfutask.repository;

import com.maxlvshv.urfutask.entity.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Репозиторий для работы с сущностями Institute.
 * Предоставляет методы для выполнения операций CRUD
 *  (создание, чтение, обновление, удаление) с сущностями Institute.
 */
@Repository
public interface InstituteRepository extends JpaRepository<Institute, UUID> {
    boolean existsByTitle(String title);
}

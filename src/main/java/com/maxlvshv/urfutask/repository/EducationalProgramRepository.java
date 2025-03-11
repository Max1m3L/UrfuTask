package com.maxlvshv.urfutask.repository;

import com.maxlvshv.urfutask.entity.EducationalProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Репозиторий для работы с сущностями EducationalProgram.
 * Предоставляет методы для выполнения операций CRUD
 *  (создание, чтение, обновление, удаление) с сущностями EducationalProgram.
 */
@Repository
public interface EducationalProgramRepository extends JpaRepository<EducationalProgram, UUID> {
}

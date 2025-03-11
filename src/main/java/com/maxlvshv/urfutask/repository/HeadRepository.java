package com.maxlvshv.urfutask.repository;

import com.maxlvshv.urfutask.entity.Head;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Репозиторий для работы с сущностями Head.
 * Предоставляет методы для выполнения операций CRUD
 *  (создание, чтение, обновление, удаление) с сущностями Head.
 */
@Repository
public interface HeadRepository extends JpaRepository<Head, UUID> {
    boolean existsByFullname(String fullname);
}

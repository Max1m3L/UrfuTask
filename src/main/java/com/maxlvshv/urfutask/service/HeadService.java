package com.maxlvshv.urfutask.service;

import com.maxlvshv.urfutask.entity.Head;
import com.maxlvshv.urfutask.exception.EntityAlreadyExistsException;
import com.maxlvshv.urfutask.repository.HeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Сервис предоставляет методы для создания, обновления и удаления сущности Head.
 * Взаимодействует с репозиторием (HeadRepository) для выполнения операций с базой данных
 *
 */
@Service
public class HeadService {
    private final HeadRepository headRepository;

    @Autowired
    public HeadService(HeadRepository headRepository) {
        this.headRepository = headRepository;
    }

    /**
     * Создаёт объект Head
     * @param head
     * @return созданный head
     */
    public Head createHead(Head head) {
        if (headRepository.existsByFullname(head.getFullname())) {
            throw new EntityAlreadyExistsException("Head with name '" + head.getFullname() + "' already exists.");
        }
        return headRepository.save(head);
    }

    /**
     * Возвращает весь список head из БД
     * @return List<Head>
     */
    public List<Head> getAllHeads() {
        return headRepository.findAll();
    }

    /**
     * Обновляет существующую сущность Head
     * @param head
     * @return обновлённый head
     */
    public Head updateHead(Head head) {
        return headRepository.save(head);
    }

    /**
     * Удаляет существующую сущность head по id
     * @param uuid
     */
    public void deleteHead(UUID uuid) {
        headRepository.deleteById(uuid);
    }
}

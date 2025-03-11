package com.maxlvshv.urfutask.service;

import com.maxlvshv.urfutask.entity.Head;
import com.maxlvshv.urfutask.repository.HeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HeadService {
    private final HeadRepository headRepository;

    @Autowired
    public HeadService(HeadRepository headRepository) {
        this.headRepository = headRepository;
    }

    public Head createHead(Head head) {
        return headRepository.save(head);
    }

    public List<Head> getAllHeads() {
        return headRepository.findAll();
    }

    public Head updateHead(Head head) {
        return headRepository.save(head);
    }

    public void deleteHead(UUID uuid) {
        headRepository.deleteById(uuid);
    }
}

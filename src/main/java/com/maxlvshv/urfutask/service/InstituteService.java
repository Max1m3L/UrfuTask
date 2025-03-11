package com.maxlvshv.urfutask.service;

import com.maxlvshv.urfutask.entity.Institute;
import com.maxlvshv.urfutask.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InstituteService {
    private final InstituteRepository instituteRepository;

    @Autowired
    public InstituteService(InstituteRepository instituteRepository) {
        this.instituteRepository = instituteRepository;
    }

    public Institute createInstitute(Institute institute) {
        return instituteRepository.save(institute);
    }

    public List<Institute> getAllInstitutes() {
        return instituteRepository.findAll();
    }

    public Institute updateInstitute(Institute institute) {
        return instituteRepository.save(institute);
    }

    public void deleteInstitute(UUID uuid) {
        instituteRepository.deleteById(uuid);
    }
}

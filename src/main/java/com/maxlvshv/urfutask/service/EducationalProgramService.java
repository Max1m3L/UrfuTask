package com.maxlvshv.urfutask.service;

import com.maxlvshv.urfutask.entity.EducationalProgram;
import com.maxlvshv.urfutask.repository.EducationalProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EducationalProgramService {
    private final EducationalProgramRepository repository;

    @Autowired
    public EducationalProgramService(EducationalProgramRepository repository) {
        this.repository = repository;
    }

    public EducationalProgram createProgram(EducationalProgram program) {
        return repository.save(program);
    }

    public List<EducationalProgram> getAllPrograms() {
        return repository.findAll();
    }

    public EducationalProgram getProgram(UUID uuid) {
        return repository.findById(uuid).orElse(null);
    }

    public EducationalProgram updateProgram(EducationalProgram program) {
        return repository.save(program);
    }

    public void deleteProgram(UUID uuid) {
        repository.deleteById(uuid);
    }
}

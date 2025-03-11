package com.maxlvshv.urfutask.repository;

import com.maxlvshv.urfutask.entity.EducationalProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EducationalProgramRepository extends JpaRepository<EducationalProgram, UUID> {
}

package com.maxlvshv.urfutask.repository;

import com.maxlvshv.urfutask.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModuleRepository extends JpaRepository<Module, UUID> {
    boolean existsByTitle(String title);
}

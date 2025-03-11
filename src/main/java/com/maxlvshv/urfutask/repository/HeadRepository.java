package com.maxlvshv.urfutask.repository;

import com.maxlvshv.urfutask.entity.Head;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HeadRepository extends JpaRepository<Head, UUID> {
    boolean existsByFullname(String fullname);
}

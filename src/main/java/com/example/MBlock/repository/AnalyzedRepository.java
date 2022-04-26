package com.example.MBlock.repository;

import com.example.MBlock.domain.Analyzed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyzedRepository extends JpaRepository<Analyzed, Long> {

    Page<Analyzed> findAll(Pageable pageable);
}
package com.example.MBlock.repository;

import com.example.MBlock.domain.Consulting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultingRepository extends JpaRepository<Consulting, Long> {

    Page<Consulting> findAll(Pageable pageable);
}
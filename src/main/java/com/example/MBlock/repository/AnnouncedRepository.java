package com.example.MBlock.repository;

import com.example.MBlock.domain.Analyzed;
import com.example.MBlock.domain.Announce;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncedRepository extends JpaRepository<Announce, Long>  {

    Page<Announce> findAll(Pageable pageable);
}

package com.example.MBlock.repository;

import com.example.MBlock.domain.News;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    Slice<News> findAllBy(Pageable pageable);

    List<News> findTop3ByOrderByUpdatedAtDesc();

}
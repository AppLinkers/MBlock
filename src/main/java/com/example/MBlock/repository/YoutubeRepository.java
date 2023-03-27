package com.example.MBlock.repository;

import com.example.MBlock.domain.Youtube;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YoutubeRepository extends JpaRepository<Youtube, Long> {
}
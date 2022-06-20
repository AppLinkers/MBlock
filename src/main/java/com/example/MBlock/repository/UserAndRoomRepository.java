package com.example.MBlock.repository;

import com.example.MBlock.domain.UserAndRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAndRoomRepository extends JpaRepository<UserAndRoom, Long> {
}
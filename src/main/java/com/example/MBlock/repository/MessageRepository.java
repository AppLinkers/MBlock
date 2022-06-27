package com.example.MBlock.repository;

import com.example.MBlock.domain.Message;
import com.example.MBlock.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Optional<List<Message>> findByRoom(Room room);
}
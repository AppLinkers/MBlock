package com.example.MBlock.repository;

import com.example.MBlock.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.user_id = :user_id")
    Optional<User> findByUser_id(String user_id);

    @Query("select u.name from User u where u.user_id = :user_id")
    String findUserNameByUser_id(String user_id);
}
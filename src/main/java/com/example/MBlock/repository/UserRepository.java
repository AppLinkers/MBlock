package com.example.MBlock.repository;

import com.example.MBlock.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

<<<<<<< HEAD
    @Query("select u from User u where u.login_id = :user_id")
    Optional<User> findByUser_id(String user_id);
=======
    @Query("select u from User u where u.login_id = :login_id")
    Optional<User> findByUser_id(String login_id);
>>>>>>> 660345efb489fcb930527d605da9a3a8c648d95f

}
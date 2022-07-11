package com.example.MBlock.repository;

import com.example.MBlock.domain.User;
import com.example.MBlock.domain.type.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.login_id = :userLoginId")
    Optional<User> findByUserLoginId(String userLoginId);

    Optional<List<User>> findUserByRoleIs(Role role);

    @Override
    Optional<User> findById(Long userId);
}
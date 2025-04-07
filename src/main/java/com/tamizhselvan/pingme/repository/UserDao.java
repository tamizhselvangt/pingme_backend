package com.tamizhselvan.pingme.repository;

import com.tamizhselvan.pingme.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserDao extends JpaRepository<User, Long> {
    Optional<List<User>> findByNameIgnoreCase(String username);
}

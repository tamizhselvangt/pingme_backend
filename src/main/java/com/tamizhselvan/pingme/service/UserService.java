package com.tamizhselvan.pingme.service;


import com.tamizhselvan.pingme.models.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    public User saveUser(User user) throws IllegalAccessException;

    public Optional<User> findByUserById(Long id);
    public Optional<List<User>> findByUsername(String username);
    public List<User> getAllUsers();

    public User updateUser(User user) throws IllegalAccessException;
    public void deleteUser(Long id);
}

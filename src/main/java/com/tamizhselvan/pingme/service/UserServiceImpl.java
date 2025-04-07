package com.tamizhselvan.pingme.service;

import com.tamizhselvan.pingme.models.Department;
import com.tamizhselvan.pingme.models.Status;
import com.tamizhselvan.pingme.models.User;
import com.tamizhselvan.pingme.repository.DepartmentDao;
import com.tamizhselvan.pingme.repository.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao usersDao;

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public User saveUser(User user) throws IllegalAccessException {
        user.setStatus(Status.ONLINE);
        return usersDao.save(user);
    }

    @Override
    public Optional<User> findByUserById (Long id) {
        return usersDao.findById(id);
    }

    @Override
    public Optional<List<User>> findByUsername(String username) {
        return usersDao.findByNameIgnoreCase(username);
    }

    @Override
    public List<User> getAllUsers () {
        return usersDao.findAll();
    }

    @Override
    public User updateUser (User user) throws IllegalAccessException {
        User existingUser = usersDao.findById(user.getId()).get();
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setStatus(user.getStatus());
        return usersDao.save(existingUser);
    }

    @Override
    public void deleteUser (Long id) {
      usersDao.deleteById(id);
    }
}


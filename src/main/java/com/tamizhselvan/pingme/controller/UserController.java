package com.tamizhselvan.pingme.controller;

import com.tamizhselvan.pingme.models.User;
import com.tamizhselvan.pingme.repository.DepartmentDao;
import com.tamizhselvan.pingme.repository.UserDao;
import com.tamizhselvan.pingme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    private UserDao userDao;


    @PostMapping("/add")
    public ResponseEntity<?> createUser(@RequestBody User user) throws IllegalAccessException {

        System.out.println(user);
        if (user.getDepartmentId() == null || departmentDao.findDepartmentById(user.getDepartmentId()).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department does not exist");
        }



        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<User>> getUser(@PathVariable String username) {
        return userService.findByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @DeleteMapping("/remove/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        if(userDao.findById(userId).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist");
        }
        userService.deleteUser(userId);
        return ResponseEntity.ok().body("User deleted successfully");
    }
}
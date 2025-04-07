package com.tamizhselvan.pingme.controller;

import com.tamizhselvan.pingme.models.Department;
import com.tamizhselvan.pingme.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.saveDepartment(department));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(
                departmentService.getAllDepartments()
        );
    }

    @DeleteMapping("/remove/{departmentId}")
    public ResponseEntity<?> removeDepartment(@PathVariable Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body("Removed Successfully");
    }

}
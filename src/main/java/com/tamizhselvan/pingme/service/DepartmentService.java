package com.tamizhselvan.pingme.service;

import com.tamizhselvan.pingme.models.Department;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getAllDepartments();
    public Optional<Department> getDepartmentById(Long id);
    public Department updateDepartment(Department department);
    public void deleteDepartment(Long id);
}

package com.tamizhselvan.pingme.service;

import com.tamizhselvan.pingme.models.Department;
import com.tamizhselvan.pingme.repository.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public Department saveDepartment (Department department) {
        department.setCreatedAt(Instant.now().getEpochSecond());
        return departmentDao.save(department);
    }

    @Override
    public List<Department> getAllDepartments () {
        return departmentDao.findAll();
    }


    public Optional<Department> getDepartmentById (Long id) {
        return departmentDao.findById(id);
    }

    @Override
    public Department updateDepartment (Department department) {
        return departmentDao.save(department);
    }

    @Override
    public void deleteDepartment (Long id) {
        departmentDao.deleteById(id);
    }

}

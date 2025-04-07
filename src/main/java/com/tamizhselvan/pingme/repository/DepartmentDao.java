package com.tamizhselvan.pingme.repository;

import com.tamizhselvan.pingme.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DepartmentDao extends JpaRepository<Department, Long> {

    Department findByName(String name);
    Optional<Department> findDepartmentById(Long id);



}

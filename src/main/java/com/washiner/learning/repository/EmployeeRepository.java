package com.washiner.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.washiner.learning.model.Employee;

// Anotação @Repository indica que essa interface é um repositório Spring Data JPA.
@Repository
// EmployeeRepository herda de JpaRepository, que fornece métodos CRUD básicos.
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}


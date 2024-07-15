package com.washiner.learning.service;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washiner.learning.model.Employee;
import com.washiner.learning.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

// Anotação @Service indica que essa classe é um serviço Spring.
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    // Injeção de dependência do repositório.
    //@Autowired em algumas versoes o springboot ja reconhece ou seja nao ha necessidade de ter a anotacao
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Método para listar todos os empregados.
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Método para obter um empregado por ID.
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Método para criar um novo empregado.
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Método para atualizar um empregado existente.
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());

        return employeeRepository.save(employee);
    }

    // Método para deletar um empregado por ID.
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}


package com.washiner.learning.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.washiner.learning.model.Employee;
import com.washiner.learning.service.EmployeeService;

import java.util.List;
import java.util.Optional;

// Anotação @RestController indica que essa classe é um controlador RESTful.
@RestController
// Mapeia solicitações HTTP para "/api/employees".
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    // Injeção de dependência do serviço.
    //@Autowired nao ha necessidade em algumas versoes o springboot ja reconhece
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Método para listar todos os empregados.
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Método para obter um empregado por ID.
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para criar um novo empregado.
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    // Método para atualizar um empregado existente.
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Método para deletar um empregado por ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}


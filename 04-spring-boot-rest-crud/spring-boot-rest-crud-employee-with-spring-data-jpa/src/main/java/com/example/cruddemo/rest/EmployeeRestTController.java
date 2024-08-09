package com.example.cruddemo.rest;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestTController {

    private final EmployeeService employeeService;

    public EmployeeRestTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> findById(@PathVariable int employeeId) {
        Optional<Employee> employee = employeeService.findById(employeeId);
        if (employee.isEmpty())
            throw new RuntimeException(STR."Employee id not found - \{employeeId}");
        return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Optional<Employee> employee = employeeService.findById(employeeId);
        if (employee == null)
            throw new RuntimeException(STR."Employee id not found - \{employeeId}");
        employeeService.deleteById(employeeId);
        return STR."Deleted employee, id - \{employeeId}";
    }

}

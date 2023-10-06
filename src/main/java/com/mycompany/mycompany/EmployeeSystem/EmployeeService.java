package com.mycompany.mycompany.EmployeeSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository ;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll() ;
    }

    public void addNewEmployee(Employee employee) {

        Optional<Employee> employeeOptional =
                employeeRepository.findEmployeeByEmail(employee.getEmail()) ;
        if (employeeOptional.isPresent()) {
            throw new IllegalStateException("email takem") ;

        }
        employeeRepository.save(employee) ;

    }

    public List<Employee> searchEmployeesByName(String name) {
        return employeeRepository.findByNameContaining(name);
    }
}

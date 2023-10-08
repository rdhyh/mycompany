package com.mycompany.mycompany.EmployeeSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    public void deleteEmployee(Long employeeId) {
        employeeRepository.findById(employeeId);
        Boolean exists = employeeRepository.existsById(employeeId) ;

        if(!exists) {
            throw new IllegalStateException(
                    "employee with id " + employeeId + "does not exists"
            );
        }
        employeeRepository.deleteById(employeeId);
    }

    public List<Employee> searchEmployeesByYearsOfEmployment(int yearsOfEmployment) {
        return employeeRepository.findByYearsOfEmployment(yearsOfEmployment);
    }


}

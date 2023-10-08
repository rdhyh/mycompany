package com.mycompany.mycompany.EmployeeSystem;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    private  final EmployeeService employeeService ;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees() ;
    }

    @PostMapping
    public void registerNewEmployee(@RequestBody Employee employee) {
        employeeService.addNewEmployee(employee);
    }

    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String name) {
        return employeeService.searchEmployeesByName(name);
    }

    @DeleteMapping(path = "{employeeId}")
    public void deleteEmployee(
            @PathVariable("employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId) ;

    }

    @GetMapping("/searchByYearsOfEmployment")
    public List<Employee> searchEmployeesByYears(@RequestParam int yearsOfEmployment) {
        return employeeService.searchEmployeesByYearsOfEmployment(yearsOfEmployment);
    }




}

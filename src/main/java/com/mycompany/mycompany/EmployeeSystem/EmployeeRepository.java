package com.mycompany.mycompany.EmployeeSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    @Query("SELECT s FROM Employee s WHERE s.email = ?1 ")
    Optional<Employee> findEmployeeByEmail(String email)  ;

//    @Query("SELECT s FROM Employee s WHERE S.name = ?1")
    List<Employee> findByNameContaining(String name);

    List<Employee> findByYearsOfEmployment(int yearsOfEmployment);


}

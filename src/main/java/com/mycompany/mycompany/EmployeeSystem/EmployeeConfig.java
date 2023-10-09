package com.mycompany.mycompany.EmployeeSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return args -> {

          Employee farah = new Employee(
                  "Farah",
                  "Farah@gmail.com",
                  LocalDate.of(2020, Month.APRIL, 8)
          )  ;

            int yearsOfEmployment = farah.getYearsOfEmployment();
            farah.setYearsOfEmployment(yearsOfEmployment);

            Employee james = new Employee(
                    "James",
                    "James@gmail.com",
                    LocalDate.of(2018, Month.JANUARY, 8)
            )  ;

            yearsOfEmployment = james.getYearsOfEmployment();
            james.setYearsOfEmployment(yearsOfEmployment);


          repository.saveAll(
                  List.of(farah, james)
          );

        };

    }

}

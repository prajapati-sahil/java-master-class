package com.employeeManagementSystem.employeeManagementSystem.model;


import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeFilterDTO {

    private Integer id;

    private String firstName;

    private String lastName;

    private LocalDate dob;

    private LocalDate doj;


    private Grade grade;

}

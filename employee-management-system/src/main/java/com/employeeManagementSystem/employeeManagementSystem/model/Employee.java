package com.employeeManagementSystem.employeeManagementSystem.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Table(name = "employee")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    @NotBlank(message = "First Name should be provided")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last Name should be provided")
    private String lastName;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "doj")
    @NotNull(message = "Date of Joining should be provided")
    private LocalDate doj;

    @Column(name = "grade")
    private Grade grade;

}

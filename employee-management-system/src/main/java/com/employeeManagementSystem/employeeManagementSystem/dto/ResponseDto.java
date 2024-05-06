package com.employeeManagementSystem.employeeManagementSystem.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.employeeManagementSystem.employeeManagementSystem.model.Employee;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@Builder
public class ResponseDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Employee> employees;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer totalRecords;
}

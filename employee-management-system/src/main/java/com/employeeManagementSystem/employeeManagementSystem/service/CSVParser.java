package com.employeeManagementSystem.employeeManagementSystem.service;

import com.opencsv.exceptions.CsvValidationException;
import com.employeeManagementSystem.employeeManagementSystem.model.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CSVParser {

    List<Employee> readCsv(MultipartFile file) throws IOException, CsvValidationException;
}

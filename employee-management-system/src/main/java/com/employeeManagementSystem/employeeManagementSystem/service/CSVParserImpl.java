package com.employeeManagementSystem.employeeManagementSystem.service;


import com.employeeManagementSystem.employeeManagementSystem.model.Grade;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.employeeManagementSystem.employeeManagementSystem.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVParserImpl implements CSVParser {


    private LocalDate parseDate(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }


    @Override
    public List<Employee> readCsv(MultipartFile file) throws IOException, CsvValidationException {
        List<Employee> employees = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        CSVReader csvReader = new CSVReader(reader);
        String[] headers = csvReader.readNext();
        String[] nextRecord;
        while ((nextRecord = csvReader.readNext()) != null) {
            boolean skipRow = false;
            Employee employee = new Employee();
            for (int i = 0; i < headers.length; i++) {
                switch (headers[i].trim()) {
                    case "firstName":
                        if (nextRecord[i] == null || nextRecord[i].isEmpty()) {
                            skipRow = true;
                            break;
                        }
                        employee.setFirstName(nextRecord[i]);
                        break;
                    case "lastName":
                        if (nextRecord[i] == null || nextRecord[i].isEmpty()) {
                            skipRow = true;
                            break;
                        }
                        employee.setLastName(nextRecord[i]);
                        break;
                    case "dob":
                        if (nextRecord[i] == null || nextRecord[i].isEmpty()) {
                            skipRow = true;
                            break;
                        }
                        employee.setDob(parseDate(nextRecord[i]));
                        break;
                    case "doj":
                        if (nextRecord[i] == null || nextRecord[i].isEmpty()) {
                            skipRow = true;
                            break;
                        }
                        employee.setDoj(parseDate(nextRecord[i]));
                        break;
                    case "grade":
                        if (nextRecord[i] == null || nextRecord[i].isEmpty()) {
                            skipRow = true;
                            break;
                        }
                        switch (nextRecord[i]) {
                            case "M1":
                                employee.setGrade(Grade.M1);
                                break;
                            case "M2":
                                employee.setGrade(Grade.M2);
                                break;
                            case "M3":
                                employee.setGrade(Grade.M3);
                                break;
                            case "M4":
                                employee.setGrade(Grade.M4);
                                break;
                            case "M5":
                                employee.setGrade(Grade.M5);
                                break;
                            default:
                                employee.setGrade(Grade.M6);
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
            if (!skipRow) {
                employees.add(employee);
            }
        }
        return employees;
    }
}

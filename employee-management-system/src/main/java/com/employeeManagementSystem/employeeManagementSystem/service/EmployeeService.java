package com.employeeManagementSystem.employeeManagementSystem.service;

import com.opencsv.exceptions.CsvValidationException;
import com.employeeManagementSystem.employeeManagementSystem.dto.ResponseDto;
import com.employeeManagementSystem.employeeManagementSystem.model.Employee;
import com.employeeManagementSystem.employeeManagementSystem.model.EmployeeFilterDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EmployeeService {

    String saveEmployeeData(MultipartFile file) throws CsvValidationException, IOException;

    ResponseDto fetchEmployee(Integer id);

    String modifyEmployee(Employee employeeData);

    ResponseDto searchEmployee(Integer pageNo, Integer pageSize, EmployeeFilterDTO filterDTO);

    ResponseEntity<byte[]> generateCSV(EmployeeFilterDTO filterDTO) throws IOException;

    ResponseEntity<byte[]> sampleCSV() throws IOException;

}

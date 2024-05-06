package com.employeeManagementSystem.employeeManagementSystem.controller;


import com.opencsv.exceptions.CsvValidationException;
import com.employeeManagementSystem.employeeManagementSystem.dto.ResponseDto;
import com.employeeManagementSystem.employeeManagementSystem.model.Employee;
import com.employeeManagementSystem.employeeManagementSystem.model.EmployeeFilterDTO;
import com.employeeManagementSystem.employeeManagementSystem.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/upload")
    public ResponseEntity<String> uploadEmployeeData(@RequestParam("file") MultipartFile file) throws CsvValidationException, IOException {
        return ResponseEntity.ok().body(employeeService.saveEmployeeData(file));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> fetchEmployeeData(@PathVariable Integer id) {
        ResponseDto response = employeeService.fetchEmployee(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    public ResponseEntity<String> modifyEmployeeData(@Valid @RequestBody Employee employeeData) {
        String response = employeeService.modifyEmployee(employeeData);
        return ResponseEntity.ok().body(response);
    }
    @PostMapping("/search")
    public ResponseEntity<ResponseDto> searchEmployeeData(@RequestParam(value = "pageNo", required = false) Integer pageNo, @RequestParam(value = "pageSize", required = false) Integer pageSize, @Valid @RequestBody EmployeeFilterDTO employeeFilterDTO) {
        ResponseDto filteredResponse = employeeService.searchEmployee(pageNo, pageSize, employeeFilterDTO);
        return ResponseEntity.ok().body(filteredResponse);
    }

    @PostMapping("/export")
    public ResponseEntity<byte[]> exportToCSV(@Valid @RequestBody EmployeeFilterDTO employeeFilterDTO) throws IOException {
        return employeeService.generateCSV(employeeFilterDTO);
    }

    @PostMapping("/sampleCSV")
    public ResponseEntity<byte[]> sampleCSV() throws IOException {
        return employeeService.sampleCSV();
    }

}




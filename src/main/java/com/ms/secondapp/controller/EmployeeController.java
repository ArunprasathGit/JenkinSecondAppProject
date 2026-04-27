package com.ms.secondapp.controller;

import com.ms.secondapp.dto.ApiResponse;
import com.ms.secondapp.dto.EmployeeDTO;

import com.ms.secondapp.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody EmployeeDTO emp) {
        EmployeeDTO saved = service.save(emp);

        ApiResponse apiresponse = new ApiResponse(
                "Employee Created Successfully",
                201, saved);

        return ResponseEntity.status(HttpStatus.CREATED).body(apiresponse);

    }

    @GetMapping
    public List<EmployeeDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getById(@PathVariable Long id) {
        return service.getByid(id);
    }

    @PutMapping("/{id}")
    public EmployeeDTO update(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
        return service.updateEmp(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
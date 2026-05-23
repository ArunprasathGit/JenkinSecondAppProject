package com.ms.secondapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.secondapp.dto.ApiResponse;
import com.ms.secondapp.dto.StudentDTO;
import com.ms.secondapp.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studservice;

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody StudentDTO sdto) {
        StudentDTO dto = studservice.save(sdto);

        ApiResponse apirespone = new ApiResponse("Student created successfully", 201, dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(apirespone);
    }

}

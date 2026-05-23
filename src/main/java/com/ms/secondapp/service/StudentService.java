package com.ms.secondapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.ms.secondapp.dto.StudentDTO;
import com.ms.secondapp.model.Student;
import com.ms.secondapp.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentrepo;

    public StudentDTO save(StudentDTO sdto) {

        Student s = new Student();
        s.setId(sdto.getId());
        s.setName(sdto.getName());
        s.setGrade(sdto.getGrade());

        Student result = studentrepo.save(s);

        StudentDTO returnObj = new StudentDTO();
        returnObj.setId(s.getId());
        returnObj.setName(s.getName());
        returnObj.setGrade(s.getGrade());

        return returnObj;
    }

}

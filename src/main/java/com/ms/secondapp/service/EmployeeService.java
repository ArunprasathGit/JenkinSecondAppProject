package com.ms.secondapp.service;

import com.ms.secondapp.dto.EmployeeDTO;
import com.ms.secondapp.model.Employee;
import com.ms.secondapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public EmployeeDTO save(EmployeeDTO emp) {
        // Prevent Duplicates
        Optional<Employee> existing = repository.findByName(emp.getName());

        if (existing.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Employee already exists");
        }

        Employee e = new Employee();
        e.setName(emp.getName());
        e.setRole(emp.getRole());

        Employee saved = repository.save(e);

        EmployeeDTO dto = new EmployeeDTO();
        dto.setName(saved.getName());
        dto.setRole(saved.getRole());

        return dto;
    }

    public EmployeeDTO getByid(Long id) {
        Employee emp = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not found"));

        EmployeeDTO edto = new EmployeeDTO();
        edto.setName(emp.getName());
        edto.setRole(emp.getRole());
        return edto;
    }

    public EmployeeDTO updateEmp(Long id, EmployeeDTO edto) {
        Employee e = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        e.setName(edto.getName());
        e.setRole(edto.getRole());

        Employee updated = repository.save(e);

        EmployeeDTO result = new EmployeeDTO();
        result.setName(updated.getName());
        result.setRole(updated.getRole());

        return result;
    }

    public List<EmployeeDTO> getAll() {
        return repository.findAll().stream().map(emp -> {
            EmployeeDTO e = new EmployeeDTO();
            e.setName(emp.getName());
            e.setRole(emp.getRole());
            return e;
        }).toList();
    }

    public String delete(Long id) {
        Employee emp = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        repository.delete(emp);
        return "Employee deleted successfully";
    }
}
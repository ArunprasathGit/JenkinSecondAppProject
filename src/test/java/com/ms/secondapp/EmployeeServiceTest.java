package com.ms.secondapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import com.ms.secondapp.dto.EmployeeDTO;
import com.ms.secondapp.model.Employee;
import com.ms.secondapp.repository.EmployeeRepository;
import com.ms.secondapp.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository erep;

    @InjectMocks
    private EmployeeService eservice;

    @Test
    void shouldSaveEmployeeSuccess() {

        EmployeeDTO edto = new EmployeeDTO();
        edto.setName("Arun");
        edto.setRole("Developer");

        when(erep.findByName("Arun"))
                .thenReturn(Optional.empty());

        Employee esaved = new Employee();
        esaved.setName(edto.getName());
        esaved.setRole(edto.getRole());

        when(erep.save(any(Employee.class)))
                .thenReturn(esaved);

        EmployeeDTO result = eservice.save(edto);

        assertNotNull(result);
        assertNotNull(result.getName());
        assertNotNull(result.getRole());

        verify(erep, times(1)).save(any(Employee.class));

        System.out.println("TEST RUNNING SUCCESSFULLY");
    }

    @Test
    void shouldReturnByEmpId() {
        Employee e = new Employee();
        e.setName("Arun");
        e.setRole("Dev");

        when(erep.findById(1L))
                .thenReturn(Optional.of(e));

        EmployeeDTO result = eservice.getByid(1L);

        assertNotNull(result);
        assert result.getName().equals("Arun");

        verify(erep, times(1)).findById(1L);
    }

    @Test
    void shouldThrowExceptionWhenEmployeeNotFound() {

        when(erep.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class,
                () -> eservice.getByid(1L));

        verify(erep, times(1)).findById(1L);

    }

}

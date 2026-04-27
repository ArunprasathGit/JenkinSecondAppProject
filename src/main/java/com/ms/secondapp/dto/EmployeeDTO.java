package com.ms.secondapp.dto;

public class EmployeeDTO {

    private Long id;
    private String name;
    private String role;

    // MUST HAVE GETTERS
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    // MUST HAVE SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

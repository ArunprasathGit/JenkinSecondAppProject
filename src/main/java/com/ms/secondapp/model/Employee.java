package com.ms.secondapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(unique = true)
    private String name;
    private String email;

    public void setName(String name2) {
        this.name = name2;
    }

    public void setRole(String role) {
        this.email = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return email;
    }

    public Employee orElseThrow(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orElseThrow'");
    }

}

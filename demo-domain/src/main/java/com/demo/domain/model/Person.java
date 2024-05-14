package com.demo.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "demo_person")
public class Person {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    private String name;
    private String vorname;
    private Integer age;
}

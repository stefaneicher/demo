package com.demo.domain.dto;


import com.demo.domain.validation.DemoMyCustomValidation;
import com.demo.domain.validation.ValidationGroup;

@DemoMyCustomValidation(groups = ValidationGroup.PERSON.class)
//@DemoPersonanDaten(groups = ValidationGroup.PERSON.class)
public class PersonDto {
    private String name;
    private String vorname;
    private Integer age;
}

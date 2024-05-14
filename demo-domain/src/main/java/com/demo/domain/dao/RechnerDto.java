package com.demo.domain.dao;


import com.demo.domain.dto.PersonDto;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class RechnerDto {
    private UUID uuid;
    private String a;
    private String b;
    private List<PersonDto> personen;
}

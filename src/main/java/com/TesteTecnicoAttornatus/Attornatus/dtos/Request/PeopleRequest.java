package com.TesteTecnicoAttornatus.Attornatus.dtos.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PeopleRequest {

    private Long id;
    private Long cpf;
    private String name;
    private Date birthDate;
}

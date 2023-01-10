package com.TesteTecnicoAttornatus.Attornatus.dtos.Response;

import com.TesteTecnicoAttornatus.Attornatus.domain.People;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PeopleResponse {

    private Long id;

    private Long cpf;

    private String name;

    private Date birthDate;


    public PeopleResponse(People people) {
        this.id = people.getId();
        this.cpf = people.getCpf();
        this.name = people.getName();
        this.birthDate = people.getBirthDate();

    }
}

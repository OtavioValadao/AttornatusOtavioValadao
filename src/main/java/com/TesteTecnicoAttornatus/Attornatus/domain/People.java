package com.TesteTecnicoAttornatus.Attornatus.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "people")
@Entity
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CPF", unique = true, nullable = false)
    private Long cpf;

    @Column(name = "name")
    private String name;

    @Column(name = "bith_date")
    private Date birthDate;
}

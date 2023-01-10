package com.TesteTecnicoAttornatus.Attornatus.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "adress")
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CEP")
    private Integer cep;

    @Column(name = "street_avenue")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "is_main_address")
    private Boolean isMainAddress;

    @ManyToOne
    @JoinColumn(name = "person_oid", foreignKey = @ForeignKey(name = "fk_address_people"))
    private People people;
}

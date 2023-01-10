package com.TesteTecnicoAttornatus.Attornatus.dtos.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class AddressRequest {

    private Long id;
    private Integer cep;
    private String street;
    private String city;
    private Boolean isMainAddress;

    @NotNull
    @NotBlank
    private Long person_oid;
}

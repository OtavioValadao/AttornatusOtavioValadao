package com.TesteTecnicoAttornatus.Attornatus.dtos.Response;

import com.TesteTecnicoAttornatus.Attornatus.domain.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressResponse {


    private Long id;

    private Integer cep;

    private String street;
    private String city;

    private Boolean isMainAddress;

    public AddressResponse(Address address) {
        this.id = address.getId();
        this.cep = address.getCep();
        this.street = address.getStreet();
        this.city = address.getCity();
        this.isMainAddress = address.getIsMainAddress();
    }
}

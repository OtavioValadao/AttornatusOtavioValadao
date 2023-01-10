package com.TesteTecnicoAttornatus.Attornatus.dtos.Response;

import com.TesteTecnicoAttornatus.Attornatus.domain.People;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PersonAddressResponse extends PeopleResponse {

    private List<AddressResponse> address;

    public PersonAddressResponse(People people, List<AddressResponse> addressResponses) {
        super(people);
        this.address = addressResponses;
    }
}

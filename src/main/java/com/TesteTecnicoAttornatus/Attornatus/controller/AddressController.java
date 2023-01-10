package com.TesteTecnicoAttornatus.Attornatus.controller;

import com.TesteTecnicoAttornatus.Attornatus.domain.Address;
import com.TesteTecnicoAttornatus.Attornatus.dtos.Request.AddressRequest;
import com.TesteTecnicoAttornatus.Attornatus.dtos.Response.AddressResponse;
import com.TesteTecnicoAttornatus.Attornatus.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * @param form
     * @param uriBuilder
     * @return PersonAddressResponse()
     */
    @PostMapping("/postAddress")
    public ResponseEntity postAddress(@RequestBody @Valid AddressRequest form, UriComponentsBuilder uriBuilder) {
        try {
            Address newAddress = this.addressService.addAddress(form);

            URI uri = uriBuilder.path("/getPerson/{personOid}").buildAndExpand(newAddress.getPeople().getId()).toUri();
            return ResponseEntity.created(uri).body(new AddressResponse(newAddress));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * @param addressId
     * @param form
     * @return Status.HTTP.OK
     */
    @PutMapping("/putAddress/{addressId}")
    public ResponseEntity putAdress(@PathVariable Long addressId, @RequestBody @Valid AddressRequest form) {
        try {
            Optional<Address> optionalAddress = this.addressService.findAddressById(addressId);
            if (optionalAddress.isPresent()) {
                this.addressService.updateAddress(optionalAddress.get(), form);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}

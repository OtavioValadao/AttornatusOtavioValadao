package com.TesteTecnicoAttornatus.Attornatus.service;

import com.TesteTecnicoAttornatus.Attornatus.domain.Address;
import com.TesteTecnicoAttornatus.Attornatus.domain.People;
import com.TesteTecnicoAttornatus.Attornatus.dtos.Request.AddressRequest;
import com.TesteTecnicoAttornatus.Attornatus.repository.AddressRepository;
import com.TesteTecnicoAttornatus.Attornatus.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Address addAddress(AddressRequest form) {
        Address address = this.convert(form);
        this.addressRepository.save(address);
        return address;
    }

    private Address convert(AddressRequest form) {

        Address newAddress = new Address();

        newAddress.setStreet(form.getStreet());
        newAddress.setCep(form.getCep());
        newAddress.setIsMainAddress(form.getIsMainAddress());
        newAddress.setCity(form.getCity());


        if (form.getPerson_oid() != null) {
            Optional<People> optionalPeople = this.peopleRepository.findById(form.getPerson_oid());
            optionalPeople.ifPresent(newAddress::setPeople);
        }


        return newAddress;
    }

    public Optional<Address> findAddressById(Long addressId) {
        return this.addressRepository.findById(addressId);
    }

    public void updateAddress(Address address, AddressRequest form) {

        Address newAddress = this.convert(form);

        address.setCity(newAddress.getCity());
        address.setStreet(newAddress.getStreet());
        address.setCep(newAddress.getCep());
        address.setIsMainAddress(newAddress.getIsMainAddress());

        if (form.getPerson_oid() != null) {
            Optional<People> optionalPeople = this.peopleRepository.findById(form.getPerson_oid());
            optionalPeople.ifPresent(newAddress::setPeople);
        }

        this.addressRepository.save(address);
    }
}

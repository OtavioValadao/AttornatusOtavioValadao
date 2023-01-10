package com.TesteTecnicoAttornatus.Attornatus.service;

import com.TesteTecnicoAttornatus.Attornatus.domain.Address;
import com.TesteTecnicoAttornatus.Attornatus.domain.People;
import com.TesteTecnicoAttornatus.Attornatus.dtos.Request.PeopleRequest;
import com.TesteTecnicoAttornatus.Attornatus.dtos.Response.AddressResponse;
import com.TesteTecnicoAttornatus.Attornatus.dtos.Response.PersonAddressResponse;
import com.TesteTecnicoAttornatus.Attornatus.repository.AddressRepository;
import com.TesteTecnicoAttornatus.Attornatus.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Page<People> findAll(Pageable pageable) {
        return peopleRepository.findAll(pageable);
    }

    public Optional<People> findPersonByOid(Long personOid) {
        return this.peopleRepository.findById(personOid);
    }

    public People addPerson(PeopleRequest form) {
        People people = this.convert(form);
        this.peopleRepository.save(people);
        return people;
    }

    private People convert(PeopleRequest form) {

        People newPerson = new People();

        newPerson.setName(form.getName());
        newPerson.setCpf(form.getCpf());
        newPerson.setBirthDate(form.getBirthDate());

        return newPerson;
    }

    public void updatePerson(People people, PeopleRequest form) {

        People person = this.convert(form);

        people.setName(person.getName());
        people.setCpf(person.getCpf());
        people.setBirthDate(person.getBirthDate());
        this.peopleRepository.save(people);
    }

    public PersonAddressResponse getPersonResponse(Long personOid) {
        Optional<People> people = this.findPersonByOid(personOid);
        if (people.isPresent()) {
            List<Address> addressList = this.addressRepository.findAllByPeople_Id(personOid);
            return new PersonAddressResponse(people.get(), addressList.stream().map(AddressResponse::new).toList());
        }
        return new PersonAddressResponse();
    }
}

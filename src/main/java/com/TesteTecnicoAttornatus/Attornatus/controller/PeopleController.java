package com.TesteTecnicoAttornatus.Attornatus.controller;

import com.TesteTecnicoAttornatus.Attornatus.domain.People;
import com.TesteTecnicoAttornatus.Attornatus.dtos.Request.PeopleRequest;
import com.TesteTecnicoAttornatus.Attornatus.dtos.Response.PeopleResponse;
import com.TesteTecnicoAttornatus.Attornatus.dtos.Response.PersonAddressResponse;
import com.TesteTecnicoAttornatus.Attornatus.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;


    /**
     * @param pageable
     * @return pageable
     */
    @GetMapping("")
    public ResponseEntity<Page<People>> getAllPeople(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.peopleService.findAll(pageable));
    }

    /**
     * @param personOid
     * @return PersonAddressResponse()
     */

    @GetMapping("/getPerson/{personOid}")
    public ResponseEntity getPersonByOid(@PathVariable Long personOid) {
        try {
            Optional<People> personOptional = this.peopleService.findPersonByOid(personOid);
            if (personOptional.isPresent()) {
                PersonAddressResponse personAddressResponse = this.peopleService.getPersonResponse(personOid);
                return ResponseEntity.ok(personAddressResponse);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * @param form
     * @param uriBuilder
     * @return PeopleResponse()
     */

    @PostMapping("/postPerson")
    public ResponseEntity postPerson(@RequestBody PeopleRequest form, UriComponentsBuilder uriBuilder) {
        try {
            People newPerson = this.peopleService.addPerson(form);

            URI uri = uriBuilder.path("/getPerson/{personOid}").buildAndExpand(newPerson.getId()).toUri();
            return ResponseEntity.created(uri).body(new PeopleResponse(newPerson));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * @param personOid
     * @param form
     * @return STATUS.HTTP.OK
     */

    @PutMapping("/putPerson/{personOid}")
    public ResponseEntity putPerson(@PathVariable Long personOid, @RequestBody PeopleRequest form) {
        try {
            Optional<People> optionalPeople = this.peopleService.findPersonByOid(personOid);
            if (optionalPeople.isPresent()) {
                this.peopleService.updatePerson(optionalPeople.get(), form);
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

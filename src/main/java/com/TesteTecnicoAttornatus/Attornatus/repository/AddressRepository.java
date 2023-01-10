package com.TesteTecnicoAttornatus.Attornatus.repository;

import com.TesteTecnicoAttornatus.Attornatus.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByPeople_Id(Long personOid);
}

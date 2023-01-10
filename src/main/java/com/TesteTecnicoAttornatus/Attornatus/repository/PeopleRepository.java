package com.TesteTecnicoAttornatus.Attornatus.repository;

import com.TesteTecnicoAttornatus.Attornatus.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PeopleRepository extends JpaRepository<People, Long>, JpaSpecificationExecutor<Long> {
}

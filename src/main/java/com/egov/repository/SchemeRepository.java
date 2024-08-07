package com.egov.repository;

import com.egov.entity.SchemeMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchemeRepository extends JpaRepository<SchemeMaster,Integer> {


}
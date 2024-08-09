package com.egov.repository;

import com.egov.entity.SchemeMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchemeRepository extends JpaRepository<SchemeMaster, Integer> {


    //List<SchemeMaster> FindByName(String name);


}
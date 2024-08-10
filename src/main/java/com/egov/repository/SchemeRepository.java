package com.egov.repository;

import com.egov.entity.SchemeMaster;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchemeRepository extends JpaRepository<SchemeMaster,Integer> {

    //to search scheme by its name
	List<SchemeMaster> findBySchemeName(String schemeName);
    


}
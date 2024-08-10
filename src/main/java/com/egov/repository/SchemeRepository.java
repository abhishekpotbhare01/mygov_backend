package com.egov.repository;

import com.egov.entity.SchemeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchemeRepository extends JpaRepository<SchemeMaster,Integer> {

    //to search scheme by its name
	List<SchemeMaster> findBySchemeName(String schemeName);
    
public interface SchemeRepository extends JpaRepository<SchemeMaster, Integer> {

	// List<SchemeMaster> FindByName(String name);

}
package com.egov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egov.entity.Women;

@Repository
public interface WomenRepository extends JpaRepository<Women,Integer>{


}

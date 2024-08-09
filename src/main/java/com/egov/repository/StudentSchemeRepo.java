package com.egov.repository;

import com.egov.entity.StudentScheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSchemeRepo extends JpaRepository<StudentScheme, Integer> {
}

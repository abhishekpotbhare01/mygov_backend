package com.egov.repository;

import com.egov.entity.StudentScheme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentSchemeRepo extends JpaRepository<StudentScheme, Integer> {
}

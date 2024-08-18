package com.egov.repository;

import com.egov.entity.FarmerScheme;
import com.egov.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FarmerSchemeRepo extends JpaRepository<FarmerScheme, Integer> {


    Optional<FarmerScheme> findByUserIdUserId(Integer userId);

}

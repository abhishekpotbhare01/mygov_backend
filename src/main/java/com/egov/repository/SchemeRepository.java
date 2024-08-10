package com.egov.repository;

import com.egov.dto.AllSchemeDto;
import com.egov.entity.SchemeMaster;
import com.egov.entity.Status;
import com.egov.entity.StudentScheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchemeRepository extends JpaRepository<SchemeMaster, Integer> {

    // List<SchemeMaster> FindByName(String name);

    @Query("SELECT new com.egov.dto.AllSchemeDto(scheme, studentScheme, farmerScheme) " +
            "FROM com.egov.entity.SchemeMaster scheme " +
            "LEFT JOIN com.egov.entity.StudentScheme studentScheme ON scheme.schemeId = studentScheme.schemeMaster.schemeId " +
            "LEFT JOIN com.egov.entity.FarmerScheme farmerScheme ON scheme.schemeId = farmerScheme.schemeMaster.schemeId " +
            "WHERE scheme.schemeId = :schemeId AND (studentScheme.status =:status OR farmerScheme.status = :status)")
    List<AllSchemeDto> findBySchemeId(@Param("schemeId") Integer schemeId, @Param("status") Status status);


//    @Query("SELECT new com.egov.dto.AllSchemeDto(scheme, studentScheme, farmerScheme) " +
//            "FROM com.egov.entity.SchemeMaster scheme " +
//            "LEFT JOIN com.egov.entity.StudentScheme studentScheme ON scheme.schemeId = studentScheme.schemeMaster.schemeId " +
//            "LEFT JOIN com.egov.entity.FarmerScheme farmerScheme ON scheme.schemeId = farmerScheme.schemeMaster.schemeId " +
//            "WHERE scheme.schemeId = :schemeId AND studentScheme.status='PENDING'||farmerScheme.status='PENDING'")
//    List<AllSchemeDto> findBySchemeId(@Param("schemeId") Integer schemeId);

}
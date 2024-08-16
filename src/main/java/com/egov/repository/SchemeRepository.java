 package com.egov.repository;

import com.egov.dto.AllSchemeDto;
import com.egov.entity.SchemeMaster;
import com.egov.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchemeRepository extends JpaRepository<SchemeMaster, Integer> {

    // List<SchemeMaster> FindByName(String name);
    //to search scheme by its name
    List<SchemeMaster> findBySchemeName(String schemeName);


    @Query("SELECT new com.egov.dto.AllSchemeDto(scheme, studentScheme, farmerScheme, womenScheme) " +
            "FROM com.egov.entity.SchemeMaster scheme " +
            "LEFT JOIN com.egov.entity.StudentScheme studentScheme ON scheme.schemeId = studentScheme.schemeMaster.schemeId " +
            "LEFT JOIN com.egov.entity.FarmerScheme farmerScheme ON scheme.schemeId = farmerScheme.schemeMaster.schemeId " +
            "LEFT JOIN com.egov.entity.WomenScheme womenScheme ON scheme.schemeId = womenScheme.schemeMaster.schemeId "+
    		"WHERE scheme.schemeId = :schemeId AND (studentScheme.status =:status OR farmerScheme.status = :status OR womenScheme.status= :status)")
    List<AllSchemeDto> findBySchemeId(@Param("schemeId") Integer schemeId, @Param("status") Status status);

//    @Query(value = "SELECT scheme_id FROM women_scheme WHERE user_id = :userId " +
//            "UNION " +
//            "SELECT scheme_id FROM student_scheme WHERE user_id = :userId", 
//    nativeQuery = true)
//    List<Integer> findByUserId(@Param("userId") Integer userId); 
    
    @Query("SELECT new com.egov.dto.AllSchemeDto(scheme, studentScheme, farmerScheme, womenScheme) " +
            "FROM  com.egov.entity.SchemeMaster scheme " +
            "LEFT JOIN WomenScheme womenScheme ON scheme.schemeId = womenScheme.schemeMaster.schemeId " +
            "LEFT JOIN StudentScheme studentScheme ON scheme.schemeId = studentScheme.schemeMaster.schemeId " +
            "LEFT JOIN FarmerScheme farmerScheme ON scheme.schemeId = farmerScheme.schemeMaster.schemeId " +
            "WHERE womenScheme.userId.userId = :userId OR studentScheme.user.userId = :userId OR farmerScheme.userId.userId = :userId")
    List<AllSchemeDto> findByUid(@Param("userId") Integer userId);
   }
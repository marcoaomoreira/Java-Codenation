package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query(value = "Select * from COMPANY company " +
            "INNER JOIN CANDIDATE C " +
            "ON company.id = C.company_id " +
            "Where C.acceleration_id = :accelerationId ", nativeQuery = true)
    List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);


    @Query(value = "Select * from COMPANY company " +
            "INNER JOIN CANDIDATE C " +
            "ON company.id = C.company_id " +
            "Where C.user_id like %:userId ", nativeQuery = true)
    List<Company> findByUserId(@Param("userId") Long userId);

    List<Company> findDistinctByCandidatesIdAccelerationId(Long accelerationId);
}

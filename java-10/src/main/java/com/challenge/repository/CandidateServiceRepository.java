package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateServiceRepository extends CrudRepository<Candidate, Long> {

    Optional<Candidate> findById(CandidateId id);

    @Query(value = "Select * from CANDIDATE candidate " +
            "Where candidate.company_id like %:companyId AND " +
            "Where candidate.user_id like %:userId AND " +
            "Where candidate.acceleration_id like %:accelerationId ", nativeQuery = true)
    Optional<Candidate> findById(@Param("userId") Long userid ,@Param("companyId") Long companyId,
                                 @Param("accelerationId") Long accelerationId);

    @Query(value = "Select * from CANDIDATE candidate " +
            "Where candidate.company_id like %:companyId", nativeQuery = true)
    List<Candidate> findByCompanyId(@Param("companyId") Long companyId);

    @Query(value = "Select * from CANDIDATE candidate " +
            "Where candidate.acceleration_id like %:accelerationId ", nativeQuery = true)
    List<Candidate> findByAccelerationId(@Param("accelerationId") Long accelerationId);

}

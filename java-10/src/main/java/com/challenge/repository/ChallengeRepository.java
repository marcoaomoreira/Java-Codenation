package com.challenge.repository;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

    @Query(value = "Select * from CHALLENGE challenge " +
            "INNER JOIN ACCELERATION A " +
            "ON challenge.id = A.challenge_id " +
            "INNER JOIN SUBMISSION S " +
            "ON challenge.id = S.challenge_id " +
            "Where A.id like %:accelerations AND " +
            "S.user_id like %:userId ", nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerations") Long accelerations, @Param("userId") Long userId);
}

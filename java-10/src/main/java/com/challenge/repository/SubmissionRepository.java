package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {

    @Query(value = "Select * from SUBMISSION submission " +
            "INNER JOIN CHALLENGE C " +
            "ON submission.challenge_id = C.id " +
            "INNER JOIN ACCELERATION A " +
            "ON C.id = A.challenge_id " +
            "Where A.id like %:accelerationId AND " +
            "C.id like %:challengeId ", nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId,
                                                        @Param("accelerationId") Long accelerationId);

    @Query(value = "Select MAX(submission.score) from SUBMISSION submission " +
            "where submission.challenge_id = :challengeId " +
            "", nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);
}

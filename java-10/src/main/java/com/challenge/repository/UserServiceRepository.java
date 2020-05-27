package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserServiceRepository extends CrudRepository<User, Long> {

    @Query(value = "Select * from USERS user " +
            "INNER JOIN CANDIDATE C " +
            "ON user.id = C.user_id " +
            "INNER JOIN ACCELERATION A " +
            "ON C.acceleration_id = A.id " +
            "Where A.name like %:acceletarionName ", nativeQuery = true)
    List<User> findByAccelerationName(@Param("acceletarionName") String acceletarionName);

    @Query(value = "Select * from USERS user " +
            "INNER JOIN CANDIDATE C " +
            "ON user.id = C.user_id " +
            "Where C.company_id like %:companyId% ", nativeQuery = true)
    List<User> findByCompanyId(@Param("companyId") Long companyId);





}

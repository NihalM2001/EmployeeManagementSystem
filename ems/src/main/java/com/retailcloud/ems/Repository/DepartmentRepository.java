package com.retailcloud.ems.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.retailcloud.ems.Entity.DepartmentDetails;

public interface DepartmentRepository extends JpaRepository<DepartmentDetails, Integer>{

    @Query("""
        select d from DepartmentDetails d left join fetch d.employees where d.departmentID = :id
            """)
    Optional<DepartmentDetails> findNyIdWithEmployees(@Param("id") Integer id);
}

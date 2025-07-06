package com.retailcloud.ems.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.retailcloud.ems.Entity.EmployeeDetails;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer>{
    boolean existsByDepartment_DepartmentID(Integer departmentId);     //derived query method!!

    @Query(value = "select name, emp_id from employee_details", nativeQuery = true)
    List<Object[]> listEmpNameId();
}

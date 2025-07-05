package com.retailcloud.ems.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retailcloud.ems.Entity.EmployeeDetails;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer>{
    boolean existsByDepartment_DepartmentID(Integer departmentId);     //derived query method!!
}

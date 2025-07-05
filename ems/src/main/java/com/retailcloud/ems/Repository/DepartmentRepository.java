package com.retailcloud.ems.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retailcloud.ems.Entity.DepartmentDetails;

public interface DepartmentRepository extends JpaRepository<DepartmentDetails, Integer>{

}

package com.retailcloud.ems.mapper;

import com.retailcloud.ems.Entity.EmployeeDetails;
import com.retailcloud.ems.dto.EmployeeDTO;

public final class EmployeeMapper {
    private EmployeeMapper(){}

    public static EmployeeDTO toDto(EmployeeDetails e) //converts EmployeeDetails to EmployeeDTO thus fixing the lazy-load proxy issue
    {
        return new EmployeeDTO(
            e.getEmpId(),
            e.getName(),
            e.getRole(),
            e.getSalary(),
            e.getJoiningDate(),
            e.getDepartment().getDeptName(),
            e.getDob(),
            e.getYearlyBonusPercent(),
            e.getReportingManager(),
            e.getAddress()
        );
    }
}

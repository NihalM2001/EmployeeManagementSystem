package com.retailcloud.ems.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    
    private Integer id;
    private String  name;
    private String  role;
    private BigDecimal salary;
    private LocalDate joiningDate;
    private String  departmentName;
    private LocalDate dob;
    private BigDecimal yearlyBonusPercent;
    private String reportingManager;
    private String address;
}

package com.retailcloud.ems.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;

@Getter
public class EmployeeDTO {
    
    private Integer id;
    private String  name;
    private String  role;
    private BigDecimal salary;
    private LocalDate joiningDate;
    private String  departmentName;

}

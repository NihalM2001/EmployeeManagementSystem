package com.retailcloud.ems.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeEditDto {
    
    public String  name;
    public LocalDate dob;
    public BigDecimal salary;
    public Integer  departmentId;  
    public String   address;
    public String   role;
    public LocalDate joiningDate;
    public BigDecimal yearlyBonusPercent;
    public String   reportingManager;
}

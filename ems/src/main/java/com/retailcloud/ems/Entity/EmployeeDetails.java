package com.retailcloud.ems.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetails {
    @Id
    @GeneratedValue
    private String empId;    
    private String name;  
    private LocalDate dob;
    @Column(precision = 12, scale = 2)
    private BigDecimal salary;
    private String department;
    private String address;
    private String role;
    private LocalDate joiningDate;
    @Column(precision = 5, scale = 2)
    private BigDecimal yearlyBonusPercent;
    private String ReportingManager;
}

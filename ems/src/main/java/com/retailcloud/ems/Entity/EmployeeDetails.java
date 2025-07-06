package com.retailcloud.ems.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;    //best practive to use Integer instead of int for PKs
    private String name;  
    private LocalDate dob;
    @Column(precision = 12, scale = 2)
    private BigDecimal salary;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false, foreignKey = @ForeignKey(name = "fk_employee_department"))
    @JsonBackReference
    private DepartmentDetails department;

    private String address;
    private String role;
    private LocalDate joiningDate;
    @Column(precision = 5, scale = 2)
    private BigDecimal yearlyBonusPercent;
    private String reportingManager;
}

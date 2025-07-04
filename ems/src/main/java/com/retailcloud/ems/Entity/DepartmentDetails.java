package com.retailcloud.ems.Entity;

import java.time.LocalDate;

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
public class DepartmentDetails {
    @Id
    @GeneratedValue
    private int departmentID;
    private String deptName;
    private LocalDate creationDate;
    private String deptHead;
}

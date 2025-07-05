package com.retailcloud.ems.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentDetails {
    @Id
    @GeneratedValue
    private int departmentID;

    @Column(nullable = false, unique = true)
    private String deptName;

    private LocalDate creationDate;
    private String deptHead;
}

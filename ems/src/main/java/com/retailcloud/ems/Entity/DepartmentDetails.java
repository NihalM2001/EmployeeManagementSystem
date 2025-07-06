package com.retailcloud.ems.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentID;

    @Column(nullable = false, unique = true)
    private String deptName;

    private LocalDate creationDate;
    private String deptHead;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeDetails> employees = new ArrayList<>();        //enables the join query in DepartmentRepository something to JOIN on
}

package com.retailcloud.ems.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailcloud.ems.Entity.EmployeeDetails;
import com.retailcloud.ems.Repository.EmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeService {
    @Autowired 
    EmployeeRepository empRepo;

    public EmployeeDetails saveEmployee(EmployeeDetails empDet)
    {
        return empRepo.save(empDet);
    }

    public List<EmployeeDetails> listEmp(){
        return empRepo.findAll();
    }

    public EmployeeDetails updateEmp(String empId, EmployeeDetails empDet)
    {
        EmployeeDetails employee = new EmployeeDetails();
        boolean flag = empRepo.findById(empDet.getEmpId()).isPresent();
        if(flag)
        {
            // employee.setEmpId(empDet.getEmpId());
            employee.setName(empDet.getName());
            employee.setDob(empDet.getDob());
            employee.setDepartment(empDet.getDepartment());
            employee.setAddress(empDet.getAddress());
            employee.setJoiningDate(empDet.getJoiningDate());
            employee.setRole(empDet.getRole());
            employee.setReportingManager(empDet.getReportingManager());
            employee.setSalary(empDet.getSalary());
            employee.setYearlyBonusPercent(empDet.getYearlyBonusPercent());
        }
        return empRepo.save(employee);
    }
}

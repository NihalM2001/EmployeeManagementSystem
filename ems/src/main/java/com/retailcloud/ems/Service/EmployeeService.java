package com.retailcloud.ems.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailcloud.ems.Entity.EmployeeDetails;
import com.retailcloud.ems.Repository.DepartmentRepository;
import com.retailcloud.ems.Repository.EmployeeRepository;
import com.retailcloud.ems.dto.EmployeeDTO;
import com.retailcloud.ems.dto.EmployeeEditDto;
import com.retailcloud.ems.mapper.EmployeeMapper;

import jakarta.persistence.EntityNotFoundException;
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

    @Autowired
    DepartmentRepository deptRepo;

    public EmployeeDetails saveEmployee(EmployeeDetails empDet)
    {
        return empRepo.save(empDet);
    }

    public List<EmployeeDTO> listEmp(){
        return empRepo.findAll().stream().map(EmployeeMapper::toDto).toList();
    }

    public EmployeeDTO updateEmp(Integer empId, EmployeeEditDto empDto)
    {
        EmployeeDetails employee = empRepo.findById(empId).orElseThrow(()-> new EntityNotFoundException("Employee not found with the ID: " + empId));
        
            employee.setName(empDto.name);
            employee.setDob(empDto.dob);
            employee.setAddress(empDto.address);
            employee.setJoiningDate(empDto.joiningDate);
            employee.setRole(empDto.role);
            employee.setReportingManager(empDto.reportingManager);
            employee.setSalary(empDto.salary);
            employee.setYearlyBonusPercent(empDto.yearlyBonusPercent);
        
        return EmployeeMapper.toDto(empRepo.save(employee));
    }
}

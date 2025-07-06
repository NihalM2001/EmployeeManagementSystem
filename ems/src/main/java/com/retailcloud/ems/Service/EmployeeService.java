package com.retailcloud.ems.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public List<EmployeeDTO> listEmp(int pgNo, int pageSize){
        return empRepo.findAll(PageRequest.of(pgNo, pageSize)).stream().map(EmployeeMapper::toDto).toList();    //pagination works but doesn't show metadata as Page is converted to List
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

    public List<Map<String, Object>> listEmpNameId(boolean lookup)
    {
        List<Object[]> rows = empRepo.listEmpNameId();
        List<Map<String, Object>> result = new ArrayList<>();
        if(lookup)
        {
            for (Object[] row : rows) 
            {
                Map<String, Object> map = new HashMap<>();
                map.put("name", row[0]);
                map.put("empId", ((Number) row[1]).intValue());
                result.add(map);
            }
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid value for lookup parameter");
        }
        return result;
    }
}

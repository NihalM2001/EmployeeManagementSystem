package com.retailcloud.ems.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.retailcloud.ems.Entity.DepartmentDetails;
import com.retailcloud.ems.Repository.DepartmentRepository;
import com.retailcloud.ems.Repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Service
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentService {
    @Autowired 
    DepartmentRepository deptRepo;

    @Autowired
    EmployeeRepository empRepo; 

    public DepartmentDetails saveDept(DepartmentDetails deptDet)
    {
        return deptRepo.save(deptDet);
    }

    public Page<DepartmentDetails> listDept(int pgNo, int pageSize)
    {
        return deptRepo.findAll(PageRequest.of(pgNo, pageSize));
    }

    public DepartmentDetails editDept(Integer id, DepartmentDetails deptDet)
    {
        DepartmentDetails department = deptRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Department not found with id: " + id));
        
        department.setDeptName(deptDet.getDeptName());
        department.setDeptHead(deptDet.getDeptHead());
        department.setCreationDate(deptDet.getCreationDate());
        
        return deptRepo.save(department);
    }
     
    
    public void deleteDept(Integer id)
    {
        if(empRepo.existsByDepartment_DepartmentID(id))
        {
            throw new IllegalStateException("Cannot delete department - Employyes are still present");
        }
        deptRepo.deleteById(id);

    }

    public DepartmentDetails getDepEmp(@PathVariable Integer id, boolean expandEmployees)
    {
        if(expandEmployees)
        {
            return deptRepo.findNyIdWithEmployees(id).orElseThrow(()-> new EntityNotFoundException("Department with id" + id + "not found"));
        }
        else{
            throw new EntityNotFoundException("Department with id" + id + "not found");
        }
    }
}


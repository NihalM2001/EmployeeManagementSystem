package com.retailcloud.ems.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailcloud.ems.Entity.DepartmentDetails;
import com.retailcloud.ems.Repository.DepartmentRepository;

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

    public DepartmentDetails saveDept(DepartmentDetails deptDet)
    {
        return deptRepo.save(deptDet);
    }

    public List<DepartmentDetails> listDept()
    {
        return deptRepo.findAll();
    }

    public DepartmentDetails editDept(String id, DepartmentDetails deptDet)
    {
        DepartmentDetails department = new DepartmentDetails();
        boolean flag = deptRepo.findById(deptDet.getDepartmentID()).isPresent();
        if(flag)
        {
            department.setDeptName(deptDet.getDeptName());
            department.setDeptHead(deptDet.getDeptHead());
            department.setCreationDate(deptDet.getCreationDate());
        }
        return deptRepo.save(department);
    }
     
    public void deleteDept(int id)
    {
        deptRepo.deleteById(id);
    }
}


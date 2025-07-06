package com.retailcloud.ems.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.retailcloud.ems.Entity.DepartmentDetails;
import com.retailcloud.ems.Service.DepartmentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DepartmentController {

@Autowired
DepartmentService depService; 

    @PostMapping("/saveDept")
    public DepartmentDetails saveDept(@RequestBody DepartmentDetails saveDept)
    {     
        return depService.saveDept(saveDept);
    }

    @GetMapping("/listDept/{pgNo}/{pageSize}")
    public Page<DepartmentDetails> listDept(@PathVariable int pgNo,@PathVariable int pageSize)
    {
        return depService.listDept(pgNo,pageSize);
    }
    
    @DeleteMapping("/deleteDept/{id}")
    public void deleteDept(@PathVariable Integer id){
        depService.deleteDept(id);
    }

    @PutMapping("/editDept/{id}")
    public DepartmentDetails editDept(@PathVariable Integer id, @RequestBody DepartmentDetails deptDet)
    {
        return depService.editDept(id, deptDet);
    }
    
    @GetMapping("/listDepEmp/{id}")
    public DepartmentDetails listDepEmp(@PathVariable Integer id, @RequestParam(name ="expand", required = false) String expand)
    {
        boolean expandEmployee = "employee".equalsIgnoreCase(expand);
        return depService.getDepEmp(id, expandEmployee);
    }
}

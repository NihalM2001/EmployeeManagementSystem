package com.retailcloud.ems.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.retailcloud.ems.Entity.DepartmentDetails;
import com.retailcloud.ems.Service.DepartmentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class DepartmentController {

@Autowired
DepartmentService depService; 

    @PostMapping("/saveDept")
    public DepartmentDetails saveDept(@RequestBody DepartmentDetails saveDept)
    {     
        return depService.saveDept(saveDept);
    }

    @GetMapping("/listDept")
    public List<DepartmentDetails> listDept()
    {
        return depService.listDept();
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
    
}

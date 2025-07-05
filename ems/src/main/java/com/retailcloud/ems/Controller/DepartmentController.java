package com.retailcloud.ems.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.retailcloud.ems.Entity.DepartmentDetails;
import com.retailcloud.ems.Service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
    
}

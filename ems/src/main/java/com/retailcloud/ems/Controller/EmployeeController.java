package com.retailcloud.ems.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailcloud.ems.Entity.EmployeeDetails;
import com.retailcloud.ems.Service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    @PostMapping("/saveEmp")
    public EmployeeDetails saveEmployee(@RequestBody EmployeeDetails empDet)
    {
        return empService.saveEmployee(empDet);
    }
}

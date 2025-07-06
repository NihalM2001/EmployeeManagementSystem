package com.retailcloud.ems.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailcloud.ems.Entity.EmployeeDetails;
import com.retailcloud.ems.Service.EmployeeService;
import com.retailcloud.ems.dto.EmployeeDTO;
import com.retailcloud.ems.dto.EmployeeEditDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    @PostMapping("/saveEmp")
    public EmployeeDetails saveEmployee(@RequestBody EmployeeDetails empDet)
    {
        return empService.saveEmployee(empDet);
    }

    @GetMapping("/listEmp")
    public List<EmployeeDTO> listEmp() {
        return empService.listEmp();
    }

    @PutMapping("editEmp/{id}")
    public EmployeeDTO editEmp(@PathVariable Integer id, @RequestBody EmployeeEditDto empDto) {
        return empService.updateEmp(id, empDto);
    }
    
}

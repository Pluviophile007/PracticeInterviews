package com.example.demo.restcontroller;

import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GeneralInfoController {
    @Autowired
    EmployeeService es;

    @GetMapping("/getEmployees")
    public List<Employee> getAllEmployee()
    {
        return  es.getAllEmployees();
    }
}

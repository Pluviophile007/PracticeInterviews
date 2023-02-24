package com.example.demo.services.impl;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO ed;

    @Override
    public List<Employee> getAllEmployees() {
        return ed.getAllEmployee();
    }
}

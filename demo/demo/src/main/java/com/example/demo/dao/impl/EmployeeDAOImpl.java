package com.example.demo.dao.impl;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> allEmp = new ArrayList<>();
        Employee e1 = new Employee("Mayank", "TilakNagar", 97119);
        Employee e2 = new Employee("Shashank", "TilakNagar", 97119);
        Employee e3 = new Employee("Ankur", "TilakNagar", 97119);
        Employee e4 = new Employee("Jindgi", "TilakNagar", 97119);

        return List.of(e1,e2,e3,e4);
    }
}

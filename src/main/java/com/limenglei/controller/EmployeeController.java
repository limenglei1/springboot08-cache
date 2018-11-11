package com.limenglei.controller;

import com.limenglei.bean.Employee;
import com.limenglei.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id) {
        Employee emp = employeeService.getEmpById(id);
        return emp;
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee) {
        Employee employee1 = employeeService.updateEmp(employee);
        return employee1;

    }

    @GetMapping("/delemp")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeService.deleteEmp(id);
        return "success";
    }
}

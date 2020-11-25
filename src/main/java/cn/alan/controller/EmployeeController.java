package cn.alan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.alan.entity.Employee;
import cn.alan.service.impl.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/search")
    public List<Employee> search(String name) {
        return employeeService.search(name);
    }

}

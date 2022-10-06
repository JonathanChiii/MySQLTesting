package com.jdbc.controller;

import com.jdbc.model.Employee;
import com.jdbc.service.EmployeeService;
import com.jdbc.service.EmployeeServiceImpl;

import java.util.List;

public class EmployeeFindAll {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        List<Employee> al  = employeeService.getAllData();
        al.stream().forEach(System.out::println);
    }
}

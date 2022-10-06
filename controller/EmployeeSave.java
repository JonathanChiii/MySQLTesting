package com.jdbc.controller;

import com.jdbc.model.Employee;
import com.jdbc.service.EmployeeService;
import com.jdbc.service.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeSave {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        Employee employee = new Employee();
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter ID:");
        employee.setId(scn.nextInt());
        System.out.println("Enter Name");
        employee.setName(scn.next());
        System.out.println("Enter Email");
        employee.setEmail(scn.next());
        System.out.println("Enter Salary");
        employee.setSalary(scn.nextInt());
        employeeService.save(employee);
    }
}

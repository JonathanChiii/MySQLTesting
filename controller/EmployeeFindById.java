package com.jdbc.controller;

import com.jdbc.model.Employee;
import com.jdbc.service.EmployeeService;
import com.jdbc.service.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeFindById {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        Scanner scn = new Scanner(System.in);
        System.out.println("Input Id to find:");
        int id = scn.nextInt();
        Employee employee = employeeService.getById(id);
        System.out.println(employee);

        // Layer Architecture
        // packages: controller, service, repository, model
        // Designing Flow: model -> repo -> service -> controller
    }
}

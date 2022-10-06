package com.jdbc.controller;

import com.jdbc.model.Employee;
import com.jdbc.service.EmployeeService;
import com.jdbc.service.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeDelete {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();

        Scanner scn = new Scanner(System.in);
        System.out.println("Input Id to delete:");
        int id = scn.nextInt();
        System.out.println(employeeService.delete(id));
    }
}

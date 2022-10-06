package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertData {

    public static void main(String[] args) {

        Registration reg = new Registration();
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
        reg.save(employee);

        FetchData fd = new FetchData();
        List<Employee> al = new ArrayList<>();
        al = fd.getAllData();
        System.out.println(al);
    
    }
}

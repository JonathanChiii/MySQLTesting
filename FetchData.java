package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FetchData {
    List<Employee> al= new ArrayList<>();
    Connection conn = null;

    public List<Employee> getAllData(){
        conn = DBLogic.getConnection();
        Employee employee = null;
        PreparedStatement ps;
        try{
            ps = conn.prepareStatement("select * from employee");
            ResultSet results = ps.executeQuery(); // ResultSet is a 2 dimensional array
            while(results.next()){
                employee = new Employee();
                int id = results.getInt("id");
                employee.setId(id);
                String name = results.getString("name");
                employee.setName(name);
                String email = results.getString("email");
                employee.setEmail(email);
                int salary = results.getInt("salary");
                employee.setSalary(salary);
                al.add(employee);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return al;
    }

}

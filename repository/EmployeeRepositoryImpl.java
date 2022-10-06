package com.jdbc.repository;

import com.jdbc.utility.DBLogic;
import com.jdbc.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository{
    Connection conn = null;
    PreparedStatement ps;

    @Override
    public String save(Employee employee) {
        conn = DBLogic.getConnection();
        String res = "Data not saved.";
        try{
            ps = conn.prepareStatement("insert into employee(id, name, email, salary) value (?, ?, ?, ?)");
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getEmail());
            ps.setInt(4, employee.getSalary());

            // 4. Execute the query
            int result = ps.executeUpdate(); // return 0 or 1

            // 5. Fetch the result
            if(result != 0) {
                res = "Data saved successfully";
            }

        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            // 6. Close the connection
            try{
                conn.close();
            }catch(SQLException e2){
                e2.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public void update(Employee e) {

    }

    @Override
    public List<Employee> getAllData() {
        conn = DBLogic.getConnection();
        List<Employee> al= new ArrayList<>();
        Employee employee = null;
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
        }finally {
            // 6. Close the connection
            try{
                conn.close();
            }catch(SQLException e2){
                e2.printStackTrace();
            }
        }
        return al;
    }

    @Override
    public Employee getById(int id) {
        conn = DBLogic.getConnection();
        Employee employee = null;
        try{
            ps = conn.prepareStatement("select * from employee where id=?");
            ps.setInt(1, id);
            ResultSet results = ps.executeQuery(); // ResultSet is a 2 dimensional array
            if(results.next()){
                employee = new Employee();
                int id_1 = results.getInt("id");
                employee.setId(id_1);
                String name = results.getString("name");
                employee.setName(name);
                String email = results.getString("email");
                employee.setEmail(email);
                int salary = results.getInt("salary");
                employee.setSalary(salary);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            // 6. Close the connection
            try{
                conn.close();
            }catch(SQLException e2){
                e2.printStackTrace();
            }
        }
        return employee;
    }

    @Override
    public String delete(int id) {
        conn = DBLogic.getConnection();
        Employee employee = null;
        String res = "Data not deleted.";
        try{
            ps = conn.prepareStatement("delete from employee where id=?");
            ps.setInt(1, id);
            int result = ps.executeUpdate(); // ResultSet is a 2 dimensional array

            if(result != 0) {
                res = "Data deleted successfully";
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            // 6. Close the connection
            try{
                conn.close();
            }catch(SQLException e2){
                e2.printStackTrace();
            }
        }
        return res;
    }
}

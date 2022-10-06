package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration {
    Connection conn = null;

    public void save(Employee employee){
        conn = DBLogic.getConnection();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("insert into employee(id, name, email, salary) value (?, ?, ?, ?)");
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getEmail());
            ps.setInt(4, employee.getSalary());

            // 4. Execute the query
            int result = ps.executeUpdate(); // return 0 or 1

            // 5. Fetch the result
            if(result == 0) {
                System.out.println("Data not inserted.");
            }else{
                System.out.println("Data inserted successfully");
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

    }
}
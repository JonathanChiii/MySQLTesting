package com.jdbc.repository;

import com.jdbc.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    String save(Employee e);
    void update(Employee e);
    List<Employee> getAllData();
    Employee getById(int id);
    String delete(int id);
}

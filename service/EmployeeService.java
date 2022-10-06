package com.jdbc.service;

import com.jdbc.model.Employee;
import java.util.List;

public interface EmployeeService {
    String save(Employee e);
    void update(Employee e);
    List<Employee> getAllData();
    Employee getById(int id);
    String delete(int id);
}

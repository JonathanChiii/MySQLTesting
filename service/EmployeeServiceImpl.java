package com.jdbc.service;

import com.jdbc.model.Employee;
import com.jdbc.repository.EmployeeRepository;
import com.jdbc.repository.EmployeeRepositoryImpl;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public String save(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public void update(Employee e) {
        employeeRepository.update(e);
    }

    @Override
    public List<Employee> getAllData() {
        return employeeRepository.getAllData();
    }

    @Override
    public Employee getById(int id) {
        return employeeRepository.getById(id);
    }

    @Override
    public String delete(int id) {
        return employeeRepository.delete(id);
    }
}

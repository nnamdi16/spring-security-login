package com.nnamdi.web.dao;

import com.nnamdi.web.model.Employee;

import java.util.List;

public interface EmployeeDAO {
      void saveEmployee(Employee employee);
     Employee getEmployeeById(Long id);
    void updateEmployee(Employee employee);
     void deleteEmployee(Long id);
     List<Employee> getAllEmployees();
}

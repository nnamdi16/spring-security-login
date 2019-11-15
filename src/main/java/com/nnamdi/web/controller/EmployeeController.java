package com.nnamdi.web.controller;

import com.nnamdi.web.dao.EmployeeDAO;
import com.nnamdi.web.dao.EmployeeDAOImpl;
import com.nnamdi.web.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDAOImpl employeeDAO;

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public void saveEmployee(@RequestBody Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeDAO.getEmployeeById(id);
        return employee;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> listEmployees() {
        System.out.println("I am a user o ");
        List<Employee> employeeList = employeeDAO.getAllEmployees();
        return employeeList;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public void update(@RequestBody Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeDAO.deleteEmployee(id);
    }
}

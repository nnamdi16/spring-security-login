package com.nnamdi.web.dao;

import com.nnamdi.web.model.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    //jdbcTemplate setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Save a new Employee
     * @param employee Employee info such as name,age, department etc
     */
    @Override
    public void saveEmployee(Employee employee) {
        String sql = "insert into employee values(?,?,?,?)";
        jdbcTemplate.update(sql, new Object[] {
                employee.getId(),
                employee.getName(),
                employee.getAge(),
                employee.getDept(),
        });
    }

    /**
     * Get a particular Employee
     * @param id employee id
     * @return Return the employee data
     */
    @Override
    public Employee getEmployeeById(Long id) {
        String sql = "select * from employee where id=?";
        Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee employee1 = new Employee();
                employee1.setId(rs.getLong(1));
                employee1.setName(rs.getString(2));
                employee1.setAge(rs.getLong(3));
                employee1.setDept(rs.getString(4));
                return employee1;
            }
        });
        return employee;
    }

    /**
     * Updating a particular Employee
     * @param employee
     */
    @Override
    public void updateEmployee(Employee employee) {
        String sql = "update employee set age =?, dept=?, name=? where id=?";
        jdbcTemplate.update(sql, new Object[]{
                employee.getAge(),
                employee.getDept(),
                employee.getName(),
                employee.getId()
        });
    }

    /**
     * Delete a particular employee
     * @param id
     */
    @Override
    public void deleteEmployee(Long id) {
        String sql  = "delete from employee where id=?";
        jdbcTemplate.update(sql, new Object[]{id});

    }


    /**
     * Get all Employees
     * @return
     */

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "select * from employee ";
        List<Employee> employeeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Employee>>() {
            @Override
            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Employee> list = new ArrayList<Employee>();
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setId(rs.getLong(1));
                    employee.setName(rs.getString(2));
                    employee.setAge(rs.getLong(3));
                    employee.setDept(rs.getString(4));
                    list.add(employee);
                }
                return list;
            }
        });
        return employeeList;
    }
}

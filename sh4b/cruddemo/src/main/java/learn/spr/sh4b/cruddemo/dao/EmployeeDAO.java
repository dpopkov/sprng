package learn.spr.sh4b.cruddemo.dao;

import learn.spr.sh4b.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}

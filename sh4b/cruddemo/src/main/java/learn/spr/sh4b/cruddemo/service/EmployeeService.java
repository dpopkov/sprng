package learn.spr.sh4b.cruddemo.service;

import learn.spr.sh4b.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(long id);

    void save(Employee employee);

    void deleteById(long id);
}

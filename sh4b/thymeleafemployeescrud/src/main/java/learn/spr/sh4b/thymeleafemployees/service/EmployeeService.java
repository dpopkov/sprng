package learn.spr.sh4b.thymeleafemployees.service;

import learn.spr.sh4b.thymeleafemployees.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    List<Employee> findAllByOrderByLastNameAsc();

    Employee findById(long id);

    void save(Employee employee);

    void deleteById(long id);
}

package learn.spr.sh4b.thymeleafemployees.service;

import learn.spr.sh4b.thymeleafemployees.dao.EmployeeRepository;
import learn.spr.sh4b.thymeleafemployees.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    @Override
    public Employee findById(long id) {
        Optional<Employee> result = employeeRepository.findById(id);
        if (result.isEmpty()) {
            throw new RuntimeException("Employee id not found - " + id);
        }
        return result.get();
    }

    @Transactional
    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }
}

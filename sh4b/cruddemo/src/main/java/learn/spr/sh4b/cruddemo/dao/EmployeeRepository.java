package learn.spr.sh4b.cruddemo.dao;

import learn.spr.sh4b.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

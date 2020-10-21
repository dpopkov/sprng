package learn.spr.sh4b.thymeleafemployees.dao;

import learn.spr.sh4b.thymeleafemployees.entity.Employee ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /** Sorts by last name. */
    List<Employee> findAllByOrderByLastNameAsc();
}

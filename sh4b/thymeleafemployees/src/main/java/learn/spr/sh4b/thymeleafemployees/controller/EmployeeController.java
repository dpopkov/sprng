package learn.spr.sh4b.thymeleafemployees.controller;

import learn.spr.sh4b.thymeleafemployees.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employees;

    @PostConstruct
    private void loadData() {
        employees = new ArrayList<>();
        employees.add(new Employee(1, "Tom", "Tannenbaum", "tom@example.com"));
        employees.add(new Employee(2, "Alex", "Burton", "burton@example.com"));
        employees.add(new Employee(3, "Jane", "Draper", "jane@example.com"));
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employees);
        return "list-employees";
    }
}

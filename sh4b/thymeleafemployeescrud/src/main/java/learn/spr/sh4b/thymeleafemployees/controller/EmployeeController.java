package learn.spr.sh4b.thymeleafemployees.controller;

import learn.spr.sh4b.thymeleafemployees.entity.Employee;
import learn.spr.sh4b.thymeleafemployees.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    // Since there is only one constructor, @Autowired is optional
    // @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAllByOrderByLastNameAsc();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        // Use a redirect to prevent duplicate submissions.
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") long id,
                                    Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "/employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam("employeeId") long id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}

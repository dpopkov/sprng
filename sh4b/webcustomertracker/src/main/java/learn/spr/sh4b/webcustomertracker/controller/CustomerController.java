package learn.spr.sh4b.webcustomertracker.controller;

import learn.spr.sh4b.webcustomertracker.entity.Customer;
import learn.spr.sh4b.webcustomertracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> allCustomers = customerService.getCustomers();
        model.addAttribute("allCustomers", allCustomers);
        return "list-customers";
    }
}

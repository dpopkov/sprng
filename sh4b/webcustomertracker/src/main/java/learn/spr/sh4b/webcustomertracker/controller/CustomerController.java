package learn.spr.sh4b.webcustomertracker.controller;

import learn.spr.sh4b.webcustomertracker.dao.CustomerDAO;
import learn.spr.sh4b.webcustomertracker.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> allCustomers = customerDAO.getCustomers();
        model.addAttribute("allCustomers", allCustomers);
        return "list-customers";
    }
}

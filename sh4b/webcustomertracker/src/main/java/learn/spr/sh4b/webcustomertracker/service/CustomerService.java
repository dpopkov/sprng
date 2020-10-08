package learn.spr.sh4b.webcustomertracker.service;

import learn.spr.sh4b.webcustomertracker.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}

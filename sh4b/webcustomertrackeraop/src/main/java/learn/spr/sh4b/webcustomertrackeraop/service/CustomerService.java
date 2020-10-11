package learn.spr.sh4b.webcustomertrackeraop.service;

import learn.spr.sh4b.webcustomertrackeraop.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}

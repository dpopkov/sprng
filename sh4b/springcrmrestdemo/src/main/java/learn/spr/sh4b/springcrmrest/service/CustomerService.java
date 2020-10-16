package learn.spr.sh4b.springcrmrest.service;

import learn.spr.sh4b.springcrmrest.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}

package learn.spr.sh4b.webcustomertracker.dao;

import learn.spr.sh4b.webcustomertracker.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(long id);

    void deleteCustomer(long id);
}

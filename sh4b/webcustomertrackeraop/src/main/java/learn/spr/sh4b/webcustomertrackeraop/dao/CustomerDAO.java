package learn.spr.sh4b.webcustomertrackeraop.dao;

import learn.spr.sh4b.webcustomertrackeraop.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(long id);

    void deleteCustomer(long id);
}

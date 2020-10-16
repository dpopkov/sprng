package learn.spr.sh4b.springcrmrest.dao;

import learn.spr.sh4b.springcrmrest.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(long id);

    void deleteCustomer(long id);
}

package learn.spr.sh4b.webcustomertrackeraop.service;

import learn.spr.sh4b.webcustomertrackeraop.dao.CustomerDAO;
import learn.spr.sh4b.webcustomertrackeraop.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Transactional
    @Override
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Transactional
    @Override
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    @Transactional
    @Override
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }
}

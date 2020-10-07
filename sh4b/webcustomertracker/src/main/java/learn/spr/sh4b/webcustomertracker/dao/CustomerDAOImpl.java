package learn.spr.sh4b.webcustomertracker.dao;

import learn.spr.sh4b.webcustomertracker.entity.Customer;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.openSession();
        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        return query.getResultList();
    }
}

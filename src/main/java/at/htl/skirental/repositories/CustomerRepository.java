package at.htl.skirental.repositories;

import at.htl.skirental.entity.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    @Transactional
    public void addCustomer(Customer newCustomer) {
        persist(newCustomer);
    }

    public List<Customer> getAllCustomers() {
        return listAll();
    }

    public Customer getCustomerById(Long id) {
        return findById(id);
    }
}

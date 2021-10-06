package at.htl.skirental.repositories;

import at.htl.skirental.entity.Customer;
import at.htl.skirental.entity.Rental;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class RentalRepository implements PanacheRepository<Rental> {
    @Transactional
    public void addRental(Rental newRental) {
        persist(newRental);
    }

    public List<Rental> getAllRentals() {
        return listAll();
    }

    public List<Rental> getRentalByCustomer(Customer customer) {
        return listAll().stream().filter(rental -> rental.getCustomer().equals(customer)).collect(Collectors.toList());
    }
}

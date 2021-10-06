package at.htl.skirental.boundary;

import at.htl.skirental.entity.Customer;
import at.htl.skirental.entity.Rental;
import at.htl.skirental.repositories.CustomerRepository;
import at.htl.skirental.repositories.RentalRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("api")
public class RentalService {
    @Inject
    RentalRepository rentalRepository;

    @Inject
    CustomerRepository customerRepository;

    @POST
    @Path("rental")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Rental rental) {
        rentalRepository.addRental(rental);
        return Response.ok(rental, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("rental")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Rental> getAllRentals() {
        return rentalRepository.getAllRentals();
    }


    @GET
    @Path("rental/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Rental> getCurrentRentalsByCustomer(@PathParam("id") Long id) {
        Customer customer = customerRepository.getCustomerById(id);
        return rentalRepository.getRentalByCustomer(customer);
    }
}

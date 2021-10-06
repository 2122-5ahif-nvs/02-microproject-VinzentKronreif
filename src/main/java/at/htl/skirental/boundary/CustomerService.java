package at.htl.skirental.boundary;

import at.htl.skirental.entity.Customer;
import at.htl.skirental.entity.Rental;
import at.htl.skirental.entity.Ski;
import at.htl.skirental.repositories.CustomerRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("api")
public class CustomerService {
    @Inject
    CustomerRepository customerRepository;

    @POST
    @Path("customer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Customer customer) {
        customerRepository.addCustomer(customer);
        return Response.ok(customer, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("customer")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Customer> findAllCustomer() {
        return customerRepository.getAllCustomers();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Customer findCustomerById(@QueryParam("id") Long id) {
        return customerRepository.getCustomerById(id);
    }
}

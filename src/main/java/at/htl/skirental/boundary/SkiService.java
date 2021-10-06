package at.htl.skirental.boundary;

import at.htl.skirental.repositories.SkiRentalRepository;
import at.htl.skirental.entity.Ski;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("api")
public class SkiService {
    @Inject
    SkiRentalRepository repository;

    @POST
    @Path("ski")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Ski ski) {
        repository.addSki(ski);
        return Response.ok(ski, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("ski/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Ski findSki(@PathParam("id") Long id) {
        return repository.findSki(id);
    }

    @GET
    @Path("ski")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ski> findAllSki() {
        return repository.findAllSkis();
    }

    @PUT
    @Path("ski/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, Ski ski) {
        repository.update(id, ski);
        return Response.ok(ski, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("ski/{id}")
    public Response delete(@PathParam("id") Long id) {
        repository.removeSki(id);
        return Response.noContent().build();
    }
}

package ru.geekbrains.rest;

import ru.geekbrains.service.ProductRepr;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/product")
public interface ProductServiceRs {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void insert(ProductRepr productRepr);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    void update(ProductRepr productRepr);

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    void delete(@PathParam("id") long id);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    ProductRepr findByIdRs(@PathParam("id") long id);

    @GET
    @Path("/{category_id}")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductRepr> findByCategoryId(@PathParam("category_id") long id);

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    ProductRepr findByName(@PathParam("name") String name);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductRepr> findAll();
}

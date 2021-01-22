package cz.educanet.milujuzivotlmaoxd;

import cz.educanet.milujuzivotlmaoxd.models.CareTakers;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.inject.*;


@Path("caretakers")
@Produces(MediaType.APPLICATION_JSON)
public class CaretakersSource {

    @Inject
    public CaretakersManager caretakerManager;

    @GET
    public Response getAllCareTakers(){
        return Response.ok(caretakerManager.getCareTakers()).build();
    }

    @GET
    @Path("{id}")
    public Response getCareTakerById(@PathParam("id") int id){
        if (caretakerManager.doesCareTakerExist(id)){
            return Response.ok(caretakerManager.returnCareTakerById(id)).build();

        } else return Response.ok(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("create")
    public Response addCareTaker(@FormParam("name") String name,@FormParam("lastName") String lastName, @FormParam("gender") String gender){

        CareTakers careTaker = new CareTakers(name, lastName, gender);
        CaretakersManager.saveCareTaker(CaretakersManager.addCareTaker(careTaker));
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    public Response editCareTaker(@PathParam("id") int id, CareTakers careTaker){
        if(caretakerManager.editCareTaker(id, careTaker)){
            return Response.ok("Ok").build();
        } else return Response.ok(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCareTaker(@PathParam("id") int id){
        if(caretakerManager.deleteCareTakerById(id)){
            return Response.ok("Ok").build();
        } else return Response.ok(Response.Status.BAD_REQUEST).build();
    }

}

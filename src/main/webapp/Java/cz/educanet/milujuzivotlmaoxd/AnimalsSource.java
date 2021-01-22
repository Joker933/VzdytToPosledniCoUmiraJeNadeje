package cz.educanet.milujuzivotlmaoxd;

import cz.educanet.milujuzivotlmaoxd.models.Animals;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.inject.*;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


@Path("animals")
@Produces(MediaType.APPLICATION_JSON)
public class AnimalsSource {

    private ArrayList<Animals> animals = new ArrayList<Animals>();

    @Inject
    private AnimalsManager animalManager;

    @GET
    public Response getAnimals(){
        return Response.ok(animalManager.getAnimals()).build();
    }

    @GET
    @Path("{id}")
    public Response getAnimalById(@PathParam("id") int id){
        if (animalManager.doesAnimalExist(id)){
            return Response.ok(animalManager.returnAnimalById(id)).build();

        } else return Response.ok(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("create")
    public Response addAnimal(
            @FormParam("name") String name,
            @FormParam("age") int age,
            @FormParam("weight") int weight,
            @FormParam("gender") String gender){

        Animals animal = new Animals(name, age, weight, gender);
        animalManager.saveAnimal(animalManager.addAnimal(animal));
        return Response.ok("Zvíře přidáno").build();

    }

    @PUT
    @Path("{id}")
    public Response editAnimals(@PathParam("id") int id, Animals animal){
        if(animalManager.editAnimal(id, animal)){
            return Response.ok("Ok").build();
        } else return Response.ok(Response.Status.BAD_REQUEST).build();

    }

    @DELETE
    @Path("{id}")
    public Response deleteAnimals(@PathParam("id") int id){
        if(animalManager.deleteAnimalById(id)){
            return Response.ok("Ok").build();
        } else return Response.ok(Response.Status.BAD_REQUEST).build();
    }
}

package cz.educanet.milujuzivotlmaoxd;

import cz.educanet.milujuzivotlmaoxd.models.Animals;

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
        return Response.ok(animals).build();
    }

    @POST
    public Response addAnimal(@FormParam("name") String name,
                              @FormParam("age") Integer age,
                              @FormParam("weight") Integer weight,
                              @FormParam("gender") String gender){

        Animals animal = new Animals(name, age, weight, gender);

        animalManager.saveAnimal(animal);
        return Response.ok("Zvíře přidáno").build();

    }
}

package cz.educanet.milujuzivotlmaoxd;


import cz.educanet.milujuzivotlmaoxd.models.Animals;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.inject.*;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class AnimalsManager {

    private int id = 0;

    private ArrayList<Animals> animals = new ArrayList<>();


    public ArrayList<Animals> getAnimals(){
        return animals;
    }

    public Animals addAnimal(Animals animal){
        animal.setId(id);
        id++;
        animals.add(animal);
        return animal;
    }

    public boolean editAnimal(int id, Animals animal){
        Animals animalById = returnAnimalById(id);

        if(doesAnimalExist(id)){
            animal.setjmeno(animalById.getjmeno());
            animal.setvek(animalById.getvek());
            animal.setvaha(animalById.getvaha());
            animal.setpohlavi(animalById.getpohlavi());
            return true;
        }else return false;
    }

    public Animals returnAnimalById(int id){
        return animals.stream().filter(animal -> id == animal.getId()).findAny().orElse(null);
    }

    public boolean doesAnimalExist(int id){
        return animals.stream().filter(animal -> id == animal.getId()).findAny().orElse(null) != null;

    }

    public boolean deleteAnimalById(int id){
        return animals.remove(returnAnimalById(id));
    }

    public void saveAnimal(Animals animal){
        animals.add(animal);
    }
}

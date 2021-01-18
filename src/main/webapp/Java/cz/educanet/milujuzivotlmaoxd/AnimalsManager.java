package cz.educanet.milujuzivotlmaoxd;


import cz.educanet.milujuzivotlmaoxd.models.Animals;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class AnimalsManager {

    private ArrayList<Animals> animals = new ArrayList<Animals>();

    public ArrayList<Animals> getAnimal(){
        return animals;
    }

    public void saveAnimal(Animals animal){
        animals.add(animal);
    }
}

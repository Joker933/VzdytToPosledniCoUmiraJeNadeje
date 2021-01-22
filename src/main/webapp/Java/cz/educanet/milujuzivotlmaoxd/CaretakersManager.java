package cz.educanet.milujuzivotlmaoxd;

import com.sun.mail.imap.Rights;
import cz.educanet.milujuzivotlmaoxd.models.CareTakers;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.inject.*;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@ApplicationScoped
public class CaretakersManager {

    private static int id = 0;
    private ArrayList<CareTakers> careTakers = new ArrayList<CareTakers>();

    public ArrayList<CareTakers> getCareTakers(){
        return careTakers;
    }

    public static CareTakers addCareTaker(CareTakers careTaker){
        careTaker.setId(id);
        id++;
        careTakers.add(careTaker);
        return careTaker;
    }

    public boolean editCareTaker(int id, CareTakers careTaker){
        CareTakers careTakerById = returnCareTakerById(id);

        if(doesCareTakerExist(id)){
            careTaker.setjmeno(careTakerById.getjmeno());
            careTaker.setprijmeni(careTakerById.getprijmeni());
            careTaker.setpohlavi(careTakerById.getpohlavi());
            return true;
        }else return false;
    }

    public boolean doesCareTakerExist(int id){
        return careTakers.stream().filter(careTaker -> id == careTaker.getId()).findAny().orElse(null) != null;
    }

    public boolean deleteCareTakerById(int id){
        return careTakers.remove(returnCareTakerById(id));

    }

    public CareTakers returnCareTakerById(int id){
        return careTakers.stream().filter(careTaker -> id == careTaker.getId()).findAny().orElse(null);
    }

    public static void saveCareTaker(CareTakers careTaker){
        careTakers.add(careTaker);
    }
}

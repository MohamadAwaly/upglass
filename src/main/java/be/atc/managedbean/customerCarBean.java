package be.atc.managedbean;

import be.atc.entities.Car;
import be.atc.service.CarService;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class customerCarBean implements Serializable {


    private List<Car> lstCars = new ArrayList<Car>();
    private String carValueSearchBar;


    public void carsList(){
        // à mettre dans un service (que l'on peut appeler ici):
        //name , new object avec un constructeur existant voir dans JPA p158
/** Ancien code (remplacé par un service et une NamedQuery)
       EntityManager em = EMF.getEM();
        Query query = em.createQuery("select c from Car c " +
                        "where c.carPlate like :inputUser or c.model.modelName like :inputUser")
                .setParameter("inputUser","%"+carValueSearchBar+"%"); // dans une NamedQuery
  */
        CarService carService = new CarService();
        lstCars = carService.listCarWhere(carValueSearchBar);
        System.out.println("ROW FROM JPA :  "+lstCars.size());
        System.out.println("SearchBar : "+carValueSearchBar);
    }

    public List<Car> getLstCars() {
        return lstCars;
    }
    public void setLstCars(List<Car> lstCars) {
        this.lstCars = lstCars;
    }

    public String getCarValueSearchBar() {
        return carValueSearchBar;
    }

    public void setCarValueSearchBar(String carValueSearchBar) {
        this.carValueSearchBar = carValueSearchBar;
    }
}

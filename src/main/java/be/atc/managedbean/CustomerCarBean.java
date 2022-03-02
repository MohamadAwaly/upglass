package be.atc.managedbean;

import be.atc.entities.Car;
import be.atc.entities.User;
import be.atc.service.CarService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named
@RequestScoped
public class CustomerCarBean implements Serializable {
    private Logger logger = Logger.getLogger(CustomerCarBean.class);

    private List<Car> lstCars = new ArrayList<Car>();
    private String carValueSearchBar;
    private String idUser;
    private Car carSelected;

    public String carDetail(Car c){
        this.carSelected = c;
        logger.log(Level.INFO,"Car is "+carSelected.getCarPlate());
        logger.log(Level.INFO,"Car is "+carSelected.getVehicleIdentificationNumber());
        return "docCarDetail";
    }
    public List<Car> finAll(){
        CarService carService = new CarService();
        return carService.carFindAll();
    }
    public List<User> findAllUser(){
        CarService carService = new CarService();
        return carService.userFindAll();
    }
    public void carsList(){
        // à mettre dans un service (que l'on peut appeler ici):
        //name , new object avec un constructeur existant voir dans JPA p158
/** Ancien code (remplacé par un service et une NamedQuery)
 EntityManager em = EMF.getEM();
 Query query = em.createQuery("select c from Car c " +
 "where c.carPlate like :inputUser or c.model.modelName like :inputUser")
 .setParameter("inputUser","%"+carValueSearchBar+"%"); // dans une NamedQuery
 */
        System.out.println("SearchBar : "+carValueSearchBar);
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

    public Car getCarSelected() {
        return carSelected;
    }

    public void setCarSelected(Car carSelected) {
        this.carSelected = carSelected;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}

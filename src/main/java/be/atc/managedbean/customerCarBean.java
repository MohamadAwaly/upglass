package be.atc.managedbean;

import be.atc.connection.EMF;
import be.atc.connection.EntityFinderImpl;
import be.atc.entities.Car;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class customerCarBean implements Serializable {


    private List<Car> lstCars = new ArrayList<Car>();
    private String carValueSearchBar;


    public void carsList(){
        EntityManager em = EMF.getEM();
        // à mettre dans un service (que l'on peut appeler ici):
        Query query = em.createQuery("select c from Car c " +
                        "where c.carPlate like :inputUser or c.model.modelName like :inputUser")
                .setParameter("inputUser","%"+carValueSearchBar+"%"); // dans une NamedQuery
        //name , new object avec un constructeur existant voir dans JPA p158
        lstCars = query.getResultList();
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

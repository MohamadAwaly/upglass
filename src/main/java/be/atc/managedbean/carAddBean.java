package be.atc.managedbean;

import be.atc.connection.EMF;
import be.atc.entities.Car;
import be.atc.entities.Model;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class carAddBean implements Serializable {
    private Logger logger = Logger.getLogger(carAddBean.class);
    private String monString;
    private Car car = new Car();
    private Model model = new Model();

    /**
     * Functions
     */

    public void submit(){
        logger.log(Level.INFO,"Plaque : "+car.getCarPlate());
        System.out.println("INFO JIWAII");
        System.out.println(car.getCarPlate()+ " IS OKAY");
    }


    /**
    GETTERS / SETTERS
     */
    public void setCar(Car car) {
        this.car = car;
    }
    public Car getCar() {
        return car;
    }
    public void setModel(Model model) {
        this.model = model;
    }
    public Model getModel() {
        return model;
    }

    public void setMonString(String monString) {
        this.monString = monString;
    }

    public String getMonString() {
        return monString;
    }
}

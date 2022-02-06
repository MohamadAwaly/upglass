package be.atc.managedbean;

import be.atc.connection.EMF;
import be.atc.entities.Car;
import be.atc.entities.Model;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class carAddBean implements Serializable {

    private Car car;
    private Model model;



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


}

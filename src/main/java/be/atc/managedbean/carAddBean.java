package be.atc.managedbean;

import be.atc.entities.Brand;
import be.atc.entities.Car;
import be.atc.entities.Model;
import be.atc.service.CarService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class carAddBean implements Serializable {
    private Logger logger = Logger.getLogger(carAddBean.class);
    private String monString;
    private Car car = new Car();
    private Brand brandSelected;
    private Model modelSelected;
    private List<Brand> listBrand;
    private CarService carService = new CarService();

    /**
     * Functions
     */

    public void submit(){
        logger.log(Level.INFO,"Plaque : "+car.getCarPlate());
        System.out.println("INFO JIWAII");
        System.out.println(car.getCarPlate()+ " IS OKAY");
    }
    public List<Brand> lstBrand(){
        return carService.listBrand();
    }
//    public List<Model> lstModel(){
//        return carService.listModelsWhereBrandIs();
//    }


    /**
    GETTERS / SETTERS
     */
    public void setCar(Car car) {
        this.car = car;
    }
    public Car getCar() {
        return car;
    }
    public void setModelSelected(Model modelSelected) {
        this.modelSelected = modelSelected;
    }
    public Model getModelSelected() {
        return modelSelected;
    }
    public void setBrandSelected(Brand brandSelected) {
        this.brandSelected = brandSelected;
    }
    public Brand getBrandSelected() {
        return brandSelected;
    }

    public void setMonString(String monString) {
        this.monString = monString;
    }
    public String getMonString() {
        return monString;
    }
}

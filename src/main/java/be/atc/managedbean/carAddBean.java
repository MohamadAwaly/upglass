package be.atc.managedbean;

import be.atc.entities.Brand;
import be.atc.entities.Car;
import be.atc.entities.Model;
import be.atc.service.CarService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class carAddBean implements Serializable {
    private Logger logger = Logger.getLogger(carAddBean.class);
    private String monString;
    private Car car = new Car();
    private Brand brandSelected;
    private Model modelSelected;
    private CarService carService = new CarService();
    private List<Brand> listBrand = carService.listBrand();
    private List<Model> listModel;

    /**
     * Functions
     */

    public void submit(){
        logger.log(Level.INFO,"Plaque : "+car.getCarPlate());
        System.out.println("INFO JIWAII");
        System.out.println(car.getCarPlate()+ " IS OKAY");
    }

    public void obtainLstModel(){
        //logger.log(Level.INFO,"brand is "+ brandSelected.getBrandName());
        logger.log(Level.INFO,"brand is "+ monString);
        listModel = carService.listModelsWhereBrandIs(monString);
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
    public void setListBrand(List<Brand> listBrand) {
        this.listBrand = listBrand;
    }
    public List<Brand> getListBrand() {
        return listBrand;
    }
    public void setListModel(List<Model> listModel) {
        this.listModel = listModel;
    }
    public List<Model> getListModel() {
        return listModel;
    }

    public void setMonString(String monString) {
        this.monString = monString;
    }
    public String getMonString() {
        return monString;
    }
}

package be.atc.managedbean;

import be.atc.entities.Brand;
import be.atc.entities.Car;
import be.atc.entities.Model;
import be.atc.service.CarService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class carAddBean implements Serializable {
    private Logger logger = Logger.getLogger(carAddBean.class);
    private String idBrandString;
    private String idModelString;
    private String buildingDate;
    private String plateNumber;
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
        System.out.println("INFO JIWAII");
        System.out.println(car.getCarPlate()+ " IS OKAY");
        logger.log(Level.INFO,"car kilometre : "+car.getKilometers());
        logger.log(Level.INFO,"cardate : "+ car.getBuildingDate());

    }

    public void obtainLstModel(){
        //logger.log(Level.INFO,"brand is "+ brandSelected.getBrandName());
        logger.log(Level.INFO,"brand is "+ idBrandString);
        logger.log(Level.INFO,"buildig date "+ buildingDate);
        logger.log(Level.INFO,"plate "+ plateNumber);

        listModel = carService.listModelsWhereBrandIs(idBrandString);
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
    public void setIdBrandString(String idBrandString) {
        this.idBrandString = idBrandString;
    }
    public String getIdBrandString() {
        return idBrandString;
    }

    public void setIdModelString(String idModelString) {
        this.idModelString = idModelString;
    }

    public String getIdModelString() {
        return idModelString;
    }

    public String getBuildingDate() {
        return buildingDate;
    }

    public void setBuildingDate(String buildingDate) {
        this.buildingDate = buildingDate;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}

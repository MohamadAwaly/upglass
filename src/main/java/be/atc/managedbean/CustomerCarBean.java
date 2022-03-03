package be.atc.managedbean;

import be.atc.connection.EMF;
import be.atc.entities.*;
import be.atc.service.CarService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Named
@RequestScoped
public class CustomerCarBean implements Serializable {
    private Logger logger = Logger.getLogger(CustomerCarBean.class);

    private List<Car> lstCars = new ArrayList<Car>();
    private String carValueSearchBar;
    private String idUser;
    private User user;
    private Car carSelected;
    private Model model;
    private BillingDocument billingDocument;
    private BillingDocumentWindow billingDocumentWindow;
    private String windowSelected;
    private Collection<Window> windowCollection;

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
        //name , new object avec un constructeur existant voir dans JPA p158
        System.out.println("SearchBar : "+carValueSearchBar);
        CarService carService = new CarService();
        lstCars = carService.listCarWhere(carValueSearchBar);
        System.out.println("ROW FROM JPA :  "+lstCars.size());
        System.out.println("SearchBar : "+carValueSearchBar);
    }
    public List<Window> windowListWhereModelIs(Model model){
        // a mettre dans un service plus tard :
        if (model != null){
        logger.log(Level.INFO,"windowListWhereModelIs  "+model.getModelName());
        EntityManager em = EMF.getEM();
        Query query = em.createQuery("select w from Window w where w.model.idModel = :idModel")
                .setParameter("idModel",model.getIdModel());
        return  query.getResultList();
        }
        return null;
    }
//    public List<Window> windowList(){
//        // a mettre dans un service plus tard :
//        logger.log(Level.INFO,"windowList");
//        EntityManager em = EMF.getEM();
//        Query query = em.createQuery("select w from Window w");
//        return  query.getResultList();
//    }
    public String resumeBilling(){
        EntityManager em = EMF.getEM();
        Query query = em.createQuery("select w from Window w where w.idWindow = :pIdWindow")
                .setParameter("pIdWindow",Integer.parseInt(windowSelected));
        windowCollection = query.getResultList();
        Query queryUser = em.createQuery("select u from User u where u.idUSer = :pIdUser")
                .setParameter("pIdUser",Integer.parseInt(idUser));
        user = (User)queryUser.getResultList().get(0);
        billingDocument.setCar(carSelected);
        billingDocument.setUser(user);


        return "documentResumeBilling";
    };

    /**
     * GETTERS SETTERS
     */

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

    public BillingDocument getBillingDocument() {
        return billingDocument;
    }

    public void setBillingDocument(BillingDocument billingDocument) {
        this.billingDocument = billingDocument;
    }

    public BillingDocumentWindow getBillingDocumentWindow() {
        return billingDocumentWindow;
    }

    public void setBillingDocumentWindow(BillingDocumentWindow billingDocumentWindow) {
        this.billingDocumentWindow = billingDocumentWindow;
    }

    public String getWindowSelected() {
        return windowSelected;
    }

    public void setWindowSelected(String windowSelected) {
        this.windowSelected = windowSelected;
    }

    public Collection<Window> getWindowCollection() {
        return windowCollection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

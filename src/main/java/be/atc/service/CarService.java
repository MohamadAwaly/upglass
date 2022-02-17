package be.atc.service;

import be.atc.connection.EMF;
import be.atc.entities.Brand;
import be.atc.entities.Car;
import be.atc.entities.Model;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class CarService {
    private static Logger logger = Logger.getLogger(CarService.class);
    EntityManager em = EMF.getEM();
    EntityTransaction transaction = em.getTransaction();

    public void addCar(Car car){
        try {
            em.persist(car);
        }catch (Exception e){
            logger.log(Level.ERROR,"carService->addCar : "+e.getMessage());
        }finally {
            em.close();
            logger.log(Level.INFO,"Entity closed ? : "+!em.isOpen());
        }
    }
    public List<Car> listCarWhere(String where){
        Query query = em.createNamedQuery("listCar").setParameter("inputUser","%"+where+"%");
        return query.getResultList();
    }
    public List<Brand> listBrand(){
        Query query = em.createNamedQuery("listBrand");
        return query.getResultList();
    }
    public List<Model> listModelsWhereBrandIs(Brand brand){
        Query query = em.createNamedQuery("listModelWhereBrandIs").setParameter("inputUser",brand);
        return query.getResultList();
    }
}

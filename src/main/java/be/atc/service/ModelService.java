package be.atc.service;

import be.atc.connection.EMF;
import be.atc.entities.Car;
import be.atc.entities.Model;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ModelService {
    private static Logger logger = Logger.getLogger(ModelService.class);
    EntityManager em = EMF.getEM();
    EntityTransaction transaction = em.getTransaction();

    public void addModel(Model model){
        try {
            em.persist(model);
        }catch (Exception e){
            logger.log(Level.ERROR,"carService->addCar : "+e.getMessage());
        }finally {
            em.close();
            logger.log(Level.INFO,"Entity closed ? : "+!em.isOpen());
        }
    }
    public List<Car> listModelWhere(String where){
        Query query = em.createNamedQuery("listModel").setParameter("inputUser","%"+where+"%");
        return query.getResultList();
    }
}

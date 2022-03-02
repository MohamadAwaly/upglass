package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table( name = "cars" )
@NamedQueries(value = {
        @NamedQuery(name="listCar",query="select c from Car c " +
                "where c.carPlate like :inputUser or lower(c.model.modelName) like lower(:inputUser) " +
                "order by c.model.modelName asc "),
        @NamedQuery(name="findAll",query = "select c from Car c order by c.idCars desc ")
})

public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_cars", nullable = false )
    private int idCars;

    @Column( name = "vehicle_identification_number", nullable = false)
    private String vehicleIdentificationNumber;
    @Column( name = "building_date", nullable = false )
    private Date   buildingDate;
    @Column( name = "kilometers")
    private Float kilometers;
    @Column( name = "car_plate", nullable = false )
    private String carPlate;

    @ManyToOne
    @JoinColumn( name = "id_model", referencedColumnName = "id_model", nullable = false )
    private Model model;

    @OneToMany( mappedBy = "car", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Collection<BillingDocument> billingDocuments;

    //Constructor
    public Car() {

    }

    public int getIdCars() {
        return idCars;
    }

    public void setIdCars( int idCars ) {
        this.idCars = idCars;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber( String chassiNumber ) {
        this.vehicleIdentificationNumber = chassiNumber;
    }

    public Date getBuildingDate() {
        return buildingDate;
    }

    public void setBuildingDate( Date buildingDate ) {
        this.buildingDate = buildingDate;
    }

    public Float getKilometers() {
        return kilometers;
    }

    public void setKilometers( Float kilometers ) {
        this.kilometers = kilometers;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate( String carPlate ) {
        this.carPlate = carPlate;
    }

    public Model getModel() {
        return model;
    }

    public void setModel( Model model ) {
        this.model = model;
    }

    public Collection<BillingDocument> getBillingDocuments() {
        return billingDocuments;
    }

    public void setBillingDocuments( Collection<BillingDocument> billingDocuments ) {
        this.billingDocuments = billingDocuments;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        Car car = (Car) o;
        return idCars == car.idCars && vehicleIdentificationNumber.equals( car.vehicleIdentificationNumber )
                && buildingDate.equals( car.buildingDate ) && Objects.equals( kilometers, car.kilometers )
                && carPlate.equals( car.carPlate ) && Objects.equals( model, car.model )
                && Objects.equals( billingDocuments, car.billingDocuments );
    }

    @Override public int hashCode() {
        return Objects.hash( idCars, vehicleIdentificationNumber, buildingDate, kilometers, carPlate, model,
                billingDocuments );
    }

}
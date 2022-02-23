package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table( name = "models" )
@NamedQueries(value = {
        @NamedQuery(name = "listModelWhereBrandIs",query = "select m from Model m where m.brand.idBrand = :inputUser order by m.modelName asc ")
})

public class Model implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_model", nullable = false )
    private int idModel;

    @Column( name = "model_name", nullable = false, length = 255 )
    private String modelName;
    @Column( name = "code", nullable = false, length = 255 )
    private String code;
    @Column( name = "begin_date", nullable = false )
    private Date   beginDate;
    @Column( name = "end_date", nullable = false )
    private Date   endDate;

    @ManyToOne
    @JoinColumn( name = "id_brand", referencedColumnName = "id_brand", nullable = false )
    private Brand         brand;
    @ManyToOne
    @JoinColumn( name = "id_body_shel_type", referencedColumnName = "id_body_shel_type", nullable = false )
    private BodyShellType bodyShellType;

    @OneToMany( mappedBy = "model", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY )
    private Collection<Car>    cars;
    @OneToMany( mappedBy = "model", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY )
    private Collection<Window> windows;

    //Constructor
    public Model() {

    }

    public int getIdModel() {
        return idModel;
    }

    public void setIdModel( int idModel ) {
        this.idModel = idModel;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName( String modelName ) {
        this.modelName = modelName;
    }

    public String getCode() {
        return code;
    }

    public void setCode( String code ) {
        this.code = code;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate( Date beginDate ) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate( Date endDate ) {
        this.endDate = endDate;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand( Brand brand ) {
        this.brand = brand;
    }

    public BodyShellType getBodyShelType() {
        return bodyShellType;
    }

    public void setBodyShelType( BodyShellType bodyShellType ) {
        this.bodyShellType = bodyShellType;
    }

    public Collection<Car> getCars() {
        return cars;
    }

    public void setCars( Collection<Car> cars ) {
        this.cars = cars;
    }

    public Collection<Window> getWindows() {
        return windows;
    }

    public void setWindows( Collection<Window> windows ) {
        this.windows = windows;
    }

    public BodyShellType getBodyShellType() {
        return bodyShellType;
    }

    public void setBodyShellType( BodyShellType bodyShellType ) {
        this.bodyShellType = bodyShellType;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        Model model = (Model) o;
        return idModel == model.idModel && modelName.equals( model.modelName ) && code.equals( model.code )
                && beginDate.equals( model.beginDate ) && endDate.equals( model.endDate ) && Objects.equals(
                brand, model.brand ) && Objects.equals( bodyShellType, model.bodyShellType )
                && Objects.equals( cars, model.cars ) && Objects.equals( windows, model.windows );
    }

    @Override public int hashCode() {
        return Objects.hash( idModel, modelName, code, beginDate, endDate, brand, bodyShellType, cars, windows );
    }

}
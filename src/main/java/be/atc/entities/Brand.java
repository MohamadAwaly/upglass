package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table( name = "brands" )
@NamedQueries(value = {
        @NamedQuery(name = "listBrand",query = "select b from Brand b order by b.brandName asc ")
})
public class Brand implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_brand", nullable = false )
    private int    idBrand;
    @Column( name = "brand_name", nullable = false, length = 60 )
    private String brandName;

    @OneToMany( mappedBy = "brand", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY )
    private Collection<Model> models;

    //Constructor
    public Brand() {

    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand( int idBrand ) {
        this.idBrand = idBrand;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName( String brandName ) {
        this.brandName = brandName;
    }

    public Collection<Model> getModels() {
        return models;
    }

    public void setModels( Collection<Model> models ) {
        this.models = models;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        Brand brand = (Brand) o;
        return idBrand == brand.idBrand && brandName.equals( brand.brandName ) && Objects.equals( models,
                brand.models );
    }

    @Override public int hashCode() {
        return Objects.hash( idBrand, brandName, models );
    }
}
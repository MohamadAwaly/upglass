package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table( name = "cities" )
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_city", nullable = false )
    private int idCity;

    @Column( name = "city_name", nullable = false, length = 60 )
    private String cityName;

    @Column( name = "zip_code", nullable = false )
    private int zipCode;

    @ManyToOne
    @JoinColumn( name = "id_country", referencedColumnName = "id_country", nullable = false )
    private Country country;

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity( int idCity ) {
        this.idCity = idCity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName( String cityName ) {
        this.cityName = cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode( int zipCode ) {
        this.zipCode = zipCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry( Country country ) {
        this.country = country;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        City city = (City) o;
        return idCity == city.idCity && zipCode == city.zipCode && cityName.equals( city.cityName ) && country.equals(
                city.country );
    }

    @Override public int hashCode() {
        return Objects.hash( idCity, cityName, zipCode, country );
    }

}

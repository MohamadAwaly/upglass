package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table( name = "countries" )
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_country", nullable = false )
    private int idCountry;

    @Column( name = "country_name", nullable = false, length = 60 )
    private String countryName;

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry( int idCountry ) {
        this.idCountry = idCountry;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName( String countryName ) {
        this.countryName = countryName;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        Country country = (Country) o;
        return idCountry == country.idCountry && countryName.equals( country.countryName );
    }

    @Override public int hashCode() {
        return Objects.hash( idCountry, countryName );
    }
}

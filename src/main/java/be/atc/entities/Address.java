package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table( name = "addresses" )
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_address", nullable = false )
    private int idAddress;

    @Column( name = "street", nullable = false, length = 255 )
    private String street;

    @Column( name = "number", nullable = false )
    private int number;

    @Column( name = "box")
    private int box;

    @ManyToOne
    @JoinColumn( name = "id_city", referencedColumnName = "id_city", nullable = false )
    private City city;

    @OneToMany( mappedBy = "address", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    private Collection<AddressUser> addressUsers;

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress( int idAddress ) {
        this.idAddress = idAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet( String street ) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber( int number ) {
        this.number = number;
    }

    public int getBox() {
        return box;
    }

    public void setBox( int box ) {
        this.box = box;
    }

    public City getCity() {
        return city;
    }

    public void setCity( City city ) {
        this.city = city;
    }

    public Collection<AddressUser> getAddressUsers() {
        return addressUsers;
    }

    public void setAddressUsers( Collection<AddressUser> addressUsers ) {
        this.addressUsers = addressUsers;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        Address address = (Address) o;
        return idAddress == address.idAddress && number == address.number && box == address.box && street.equals(
                address.street ) && city.equals( address.city ) && Objects.equals( addressUsers,
                address.addressUsers );
    }

    @Override public int hashCode() {
        return Objects.hash( idAddress, street, number, box, city, addressUsers );
    }



}

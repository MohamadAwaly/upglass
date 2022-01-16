package be.atc.entities;


import be.atc.entities.compoundID.AddressUserPK;
import be.atc.enums.AddressTypeEnum;

import javax.persistence.*;

@Entity
@IdClass( AddressUserPK.class )
@Table( name = "address_users" )
public class AddressUser {

    @Id
    @ManyToOne
    @JoinColumn( name = "user", nullable = false )
    private User user;

    public void setUser( User user ) {
        this.user = user;
    }

    @Id
    @ManyToOne
    @JoinColumn( name = "address", nullable = false )
    private Address address;

    public void setAddress( Address address ) {
        this.address = address;
    }

    @Column( name = "address_type", nullable = false, length = 255 )
    @Enumerated( EnumType.STRING )
    private AddressTypeEnum addressType;

    public User getUser() {
        return user;
    }

    public Address getAddress() {
        return address;
    }

    public AddressTypeEnum getAddressType() {
        return addressType;
    }

    public void setAddressType( AddressTypeEnum addressType ) {
        this.addressType = addressType;
    }

}

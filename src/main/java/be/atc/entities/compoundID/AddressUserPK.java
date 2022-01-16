package be.atc.entities.compoundID;

import java.io.Serializable;

public class AddressUserPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private int user;
    private int address;

    public AddressUserPK() {
    }

    public AddressUserPK( int user, int address ) {
        this.user = user;
        this.address = address;
    }

    public int getUser() {
        return user;
    }

    public void setUser( int user ) {
        this.user = user;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress( int address ) {
        this.address = address;
    }
}

package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table( name = "payment_methods" )
public class PaymentMethod implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_payment_method", nullable = false )
    private int idPaymentMethod;

    @Column( name = "nbr_day_mode", nullable = false, length = 50 )
    private String nbrDayMode;

    @Column( name = "professional_discount", nullable = false, length = 50 )
    private String professionalDiscount;

    @ManyToOne
    @JoinColumn( name = "id_user", referencedColumnName = "id_user", nullable = false )
    private User user;

    public int getIdPaymentMethod() {
        return idPaymentMethod;
    }

    public void setIdPaymentMethod( int idPaymentMethod ) {
        this.idPaymentMethod = idPaymentMethod;
    }

    public String getNbrDayMode() {
        return nbrDayMode;
    }

    public void setNbrDayMode( String nbrDayMode ) {
        this.nbrDayMode = nbrDayMode;
    }

    public String getProfessionalDiscount() {
        return professionalDiscount;
    }

    public void setProfessionalDiscount( String professionalReduction ) {
        this.professionalDiscount = professionalReduction;
    }

    public User getUser() {
        return user;
    }

    public void setUser( User user ) {
        this.user = user;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        PaymentMethod that = (PaymentMethod) o;
        return idPaymentMethod == that.idPaymentMethod && nbrDayMode.equals( that.nbrDayMode ) && Objects.equals(
                professionalDiscount, that.professionalDiscount ) && Objects.equals( user, that.user );
    }

    @Override public int hashCode() {
        return Objects.hash( idPaymentMethod, nbrDayMode, professionalDiscount, user );
    }

}

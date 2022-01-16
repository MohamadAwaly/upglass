package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table( name = "appointments" )

public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_appointment", nullable = false )
    private int    idAppointment;
    @Column( name = "site", nullable = false, length = 255 )
    private String site;

    @OneToMany( mappedBy = "appointment", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY )
    private Collection<AppointmentHistory> appointmentHistories;
    @OneToMany( mappedBy = "appointment", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY )
    private Collection<Order>              orders;

    //Constructor
    public Appointment() {
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment( int idAppointment ) {
        this.idAppointment = idAppointment;
    }

    public String getSite() {
        return site;
    }

    public void setSite( String site ) {
        this.site = site;
    }

    public Collection<AppointmentHistory> getAppointmentHistories() {
        return appointmentHistories;
    }

    public void setAppointmentHistories( Collection<AppointmentHistory> appointmentHistories ) {
        this.appointmentHistories = appointmentHistories;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders( Collection<Order> orders ) {
        this.orders = orders;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        Appointment that = (Appointment) o;
        return idAppointment == that.idAppointment && site.equals( that.site ) && Objects.equals(
                appointmentHistories, that.appointmentHistories ) && Objects.equals( orders, that.orders );
    }

    @Override public int hashCode() {
        return Objects.hash( idAppointment, site, appointmentHistories, orders );
    }

}
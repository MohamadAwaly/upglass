package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table( name = "appointment_histories" )

public class AppointmentHistory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_appointment_history", nullable = false )
    private int  idAppointment_history;
    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "begin_date_hours", nullable = false )
    private Date beginDateHours;
    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "end_date_hours", nullable = false )
    private Date endDateHours;
    @Column( name = "status", nullable = false )
    private String status;

    @ManyToOne
    @JoinColumn( name = "id_appointment", referencedColumnName = "id_appointment", nullable = false )
    private Appointment appointment;

    @ManyToOne
    @JoinColumn( name = "id_user", referencedColumnName = "id_user", nullable = false )
    private User user;

    //Constructor
    public AppointmentHistory() {

    }

    public int getIdAppointment_history() {
        return idAppointment_history;
    }

    public void setIdAppointment_history( int idAppointment_history ) {
        this.idAppointment_history = idAppointment_history;
    }

    public Date getBeginDateHours() {
        return beginDateHours;
    }

    public void setBeginDateHours( Date beginDateHours ) {
        this.beginDateHours = beginDateHours;
    }

    public Date getEndDateHours() {
        return endDateHours;
    }

    public void setEndDateHours( Date endDateHours ) {
        this.endDateHours = endDateHours;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment( Appointment appointment ) {
        this.appointment = appointment;
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
        AppointmentHistory that = (AppointmentHistory) o;
        return idAppointment_history == that.idAppointment_history && beginDateHours.equals( that.beginDateHours )
                && endDateHours.equals( that.endDateHours ) && status.equals( that.status ) && appointment.equals(
                that.appointment ) && user.equals( that.user );
    }

    @Override public int hashCode() {
        return Objects.hash( idAppointment_history, beginDateHours, endDateHours, status, appointment, user );
    }

}
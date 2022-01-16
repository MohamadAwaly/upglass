package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table( name = "orders" )

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_order", nullable = false )
    private int     idOrder;
    @Column( name = "sale_price", nullable = false )
    private int     salePrice;
    @Column( name = "billed", nullable = false )
    private boolean billed;

    @ManyToOne
    @JoinColumn( name = "id_user", referencedColumnName = "id_user", nullable = false )
    private User        user;
    @ManyToOne
    @JoinColumn( name = "id_appointment", referencedColumnName = "id_appointment", nullable = false )
    private Appointment appointment;

    @OneToMany( mappedBy = "order", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY )
    private Collection<BillingDocument> billingDocuments;
    @OneToMany( mappedBy = "order", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
    private Collection<WindowOrder> windowOrders;

    //Constructor
    public Order() {
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder( int idOrder ) {
        this.idOrder = idOrder;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice( int salePrice ) {
        this.salePrice = salePrice;
    }

    public boolean isBilled() {
        return billed;
    }

    public void setBilled( boolean billed ) {
        this.billed = billed;
    }

    public User getUser() {
        return user;
    }

    public void setUser( User user ) {
        this.user = user;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment( Appointment appointment ) {
        this.appointment = appointment;
    }

    public Collection<BillingDocument> getBillingDocuments() {
        return billingDocuments;
    }

    public void setBillingDocuments( Collection<BillingDocument> billingDocuments ) {
        this.billingDocuments = billingDocuments;
    }

    public Collection<WindowOrder> getWindowOrders() {
        return windowOrders;
    }

    public void setWindowOrders( Collection<WindowOrder> windowOrders ) {
        this.windowOrders = windowOrders;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        Order order = (Order) o;
        return idOrder == order.idOrder && salePrice == order.salePrice && billed == order.billed
                && Objects.equals( user, order.user ) && Objects.equals( appointment,
                order.appointment ) && Objects.equals( billingDocuments, order.billingDocuments )
                && Objects.equals( windowOrders, order.windowOrders );
    }

    @Override public int hashCode() {
        return Objects.hash( idOrder, salePrice, billed, user, appointment, billingDocuments, windowOrders );
    }

}
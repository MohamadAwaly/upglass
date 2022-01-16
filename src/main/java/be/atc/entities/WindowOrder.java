package be.atc.entities;

import be.atc.entities.compoundID.WindowOrderPK;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass( WindowOrderPK.class )
@Table( name = "windows_orders" )
public class WindowOrder implements Serializable {
    private static final long  serialVersionUID = 1L;
    @Id
    @ManyToOne
    @JoinColumn( name = "orders", nullable = false )
    private Order order;
    public void setOrder( Order order ) {
        this.order = order;
    }

    @Id
    @ManyToOne
    @JoinColumn( name = "windows", nullable = false )
    private Window window;

    public void setWindow( Window window ) {
        this.window = window;
    }

    public Order getOrder() {
        return order;
    }

    public Window getWindow() {
        return window;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        WindowOrder that = (WindowOrder) o;
        return Objects.equals( order, that.order ) && Objects.equals( window, that.window );
    }

    @Override public int hashCode() {
        return Objects.hash( order, window );
    }
}
